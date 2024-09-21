_This document is a collection of guidelines an notes taken while learning Apache Kafka. Mostly intended for the author's own use._

Assuming running on Linux OS and Kafka binaries directory has been added to the `$PATH`. Commands aimed at **NOT** using Zookeper wherever possible, as it is going to be depricated with the release of Kafka 4.0.

* All commands are binaries, hence they will end with `.sh`, e.g. `kafka-topics.sh`.
* Bootstrap server option replaces Zookeeper, e.g. `kafka-topics.sh --bootstrap-server localhost:9092`


# Topics

## Create topic

    kafka-topics.sh --bootstrap-server localhost:9092

    kafka-topics.sh --bootstrap-server localhost:9092 --create --topic first_topic

    kafka-topics.sh --bootstrap-server localhost:9092 --create --topic second_topic --partitions 5

    kafka-topics.sh --bootstrap-server some_server_somewhere:9092 --create --topic third_topic --partitions 3 --replication-factor 2 

_The last command will fail on localhost, because the replication factor cannot be higher than the number of brokers  (servers that contain topic's partitions). I.e. there have to be several server machines in the Kafka cluster._

## List topics

    kafka-topics.sh --bootstrap-server localhost:9092 --list


## Describe topics

    kafka-topics.sh --bootstrap-server localhost:9092 --describe


## Delete a topic

    kafka-topics.sh --bootstrap-server  localhost:9092 --topic first_topic --delete


# Producers

## Produce without keys

    kafka-console-producer.sh --bootstrap-server localhost:9092 --topic second_topic

_The process will start listening to stdin. You can put in strings that will be written into the topic. `Ctr+C` to exit._


## Produce with keys

    kafka-console-producer.sh --bootstrap-server localhost:9092 --topic second_topic --property parse.key=true --property key.separator=:

_The producer will now expect the input in form key:message. All keyed messages will go to the same partition._

## Produce with properties

    kafka-console-producer.sh --bootstrap-server localhost:9092 --topic second_topic --producer-property acks=all

_Both the leader and all the replicas need to acknowledge the writes. Does not actually change anything in the CLI_

    kafka-console-producer.sh --bootstrap-server localhost:9092 --topic second_topic --producer-property partitioner.class=org.apache.kafka.clients.producer.RoundRobinPartitioner

_Use Round Robin algorythm to send the message to a different partition each time. Otherwise partitions switch at about 16KB of data received._

## Unknown topic

Producing to a non-exitent topic will throw an error message, something along these lines:

`[2024-09-15 22:32:33,754] WARN [Producer clientId=console-producer] Error while fetching metadata with correlation id 5 : {rogue_topic=UNKNOWN_TOPIC_OR_PARTITION} (org.apache.kafka.clients.NetworkClient)`

But(!!) the topic will then be auto-created and producer will be able to write into it. At least, on localhost. Topic auto-creation on servers can be disabled.

# Consumers

## Consume from tail of the topic 

    kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic second_topic

_This will pick up any new messages incomming to the topic. It will ignore old messages._

## Consume from the head of the topic

    kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic second_topic --from-beginning

_Will consume all the messages already in the topic and listen onwards. Will read in order for each partition, not in order of that the messages were received in (not by timestamps!!). And partitions will not necessarily be printed in order either._

## Display message details

    kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic second_topic --from-beginning --formatter org.apache.kafka.tools.consumer.DefaultMessageFormatter --property print.timestamp=true --property print.key=true --property print.value=true --property print.partition=true

# Consumer groups

## Add consumer into a group

    kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic third_topic --group my-first-application

_If group does not exist, it will be auto-created. Creating another consumer in the same group will cause the new consumer to take some of the partitions for itself. A partition-to-consumer assignment rebalancing hapens whenever a consumer is added or removed from a group, or partitions are added to a topic. If all consumers are removed (stopped), they will read the missed mesages once started back again (even if started without `--from beginning` argument)._

_It is possible to have several groups consuming from the same topic._

## List consumer groups

    kafka-consumer-groups.sh --bootstrap-server localhost:9092 --list

## Describe a consumer group

    kafka-consumer-groups.sh --bootstrap-server localhost:9092 --describe --group group-name

_Shows the topic, all the consumers, partitions that they are assigned to, partition offsets, lag and hosts_

## Static group membership
* Prevents consumers from changing their member ID and partitions on rebalancing
* Specify `group.instance.id` to make a consumer a _static member_
* Cosumer's partitions will wait for `session.timeout.ms` before rebalancing if the consumer leaves the session

# Offsets

## Resetting offsets

    # This command can only be run when all consumers in a group are stopped
    kafka-consumer-groups.sh --bootstrap-server localhost:9092 --group my-first-application --reset-offsets --to-earliest --topic third_topic --execute

_Will reset the offsets of each partition to the beginning._


# Rebalancing

**N.B. Consumers with [static group membership](https://github.com/VikSil/Reengineering_Man_AHL/blob/trunk/study/kafka/kafka_useful_commands.md#static-group-membership) do not rebalance (for a timeout)**

## Eager rebalancing

* _"Stop-the-world"_ event happens: all of the consumers are stopped and give up their partitions
* Partitions are assigned at random to the consumer
* **Cons**:
    * Consumer may end up assigned to a different set of partitions than before
    * There is a short period of time when noone is processing
* Kafka Consumer `partition.assignment.strategy`:
    * `RangeAssignor`: assigns partition on a per-topic basis (**Default**, but can lead to imbalance)
    * `RoundRobin`: balanced because all consumers get the same number of partitions (+/-1)
    * `StickyAssignor`: like RoundRobbin, and also minimises partition movements on rebalancing (but _"stop-the-world"_ event still happens)

## Incremental cooperative rebalance

* A small subset of partitions are reassigned from one consumer to the other (new) consumer
* Consumers that don't have any changes continue to process uninterrupted
* This can happen in several interations to find a stable assignment (hence "incremental")
* Kafka Consumer `partition.assignment.strategy`:
    * `CooperativeStickyAssignor`: sticky assignor without _"stop-the-world"_ event