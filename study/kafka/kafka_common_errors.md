# Java Runtime

If starting KRaft outputs something along the lines of `java.lang.RuntimeException: No readable meta.properties files found.`

From [Stack Overflow](https://stackoverflow.com/questions/54364933):

Probably, you didn't shutdown Kafka gracefully in the last run which caused this. Always shut it down with `kafka-server-stop.sh` or `Ctrl+C`. I had to format the whole storage using these commands to get it back working. Repeat the steps in [`kafka_getting_started.md`, chapter "Starting Kafka with KRaft (without Zookeeper)"](https://github.com/VikSil/Reengineering_Man_AHL/blob/trunk/study/kafka/kafka_getting_started.md#starting-kafka-with-kraft-without-zookeeper).
