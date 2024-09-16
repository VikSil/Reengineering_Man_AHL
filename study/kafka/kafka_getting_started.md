_This document is a collection of guidelines an notes taken while learning Apache Kafka. Mostly intended for the author's own use._

# Installation

Assuming Linux OS, detailed installation instructions can be found [here](https://learn.conduktor.io/kafka/how-to-install-apache-kafka-on-linux/). 

These are the installation steps that worked on my laptop specifically:

1. Install Java Development Kit, as per instruction on [Amazon Corretto 11 Debian Linux install page](https://docs.aws.amazon.com/corretto/latest/corretto-11-ug/generic-linux-install.html). Best done in a sudo activated terminal, because the password prompt gets lost in the output logs:

* Add to keyring
      
        wget -O - https://apt.corretto.aws/corretto.key | sudo gpg --dearmor -o /usr/share/keyrings/corretto-keyring.gpg && \
        echo "deb [signed-by=/usr/share/keyrings/corretto-keyring.gpg] https://apt.corretto.aws stable main" | sudo tee /etc/apt/sources.list.d/corretto.list

_the above will ask for sudo password, if not already active_

* install JDK
    
        sudo apt-get update; sudo apt-get install -y java-11-amazon-corretto-jdk

* check the installation

        java -version

_the above should output a version mentioning `Corretto`. If it does not refer to the link above for further instruction._

2. Install Kafka.

* Get the Kafka binaries from the [official download page](https://kafka.apache.org/downloads). Chose the latest supported release for **Scala 2.13**. Save the .tgz archive on the disk. Extract the archive (open the archive & _drag-and-drop_). Place the resulting kafka folder where you want to run it from, e.g. `/home/user/bin`
* Add the Kafka binary directory to the path. If using z-shell:

        cd 
        sudo nano .zshrc

    Add the following lines to the end of the file, making sure that the kafka version is correct:

        # update path to include kafka
        PATH="$PATH:/home/user/bin/kafka_2.13-3.8.0/bin"

    Read the updates out to the file and save.


* Test PATH configuration in a new terminal.

        echo $PATH

    The output should include the newly added directory.

        kafka-topics.sh

    Shoudl output instructions on how to create Kafka topics

# Starting Kafka with Zookeeper

1. Run this command:

         zookeeper-server-start.sh home/user/bin/kafka_2.13-3.8.0/config/zookeeper.properties

    There will be a lot of gibberish, an ASCII art of ZOOKEEPER, and the process will take over the terminal.

2. Run this command in a new terminal:

        kafka-server-start.sh /home/user/bin/kafka_2.13-3.8.0/config/server.properties

    There will be a lot of gibberish and the process will take over the terminal. One of the last lines should contain `[KafkaServer id=0] started (kafka.server.KafkaServer)`.

# Starting Kafka with KRaft (without Zookeeper)

1. Generate Kafka storage ID by running this command:

        kafka-storage.sh random-uuid

    _this will output a hash string_


2. Format the log directory, by running this command:

        kafka-storage.sh format -t <uuid> -c /home/user/bin/kafka_2.13-3.8.0/config/kraft/server.properties

    This will output something along the lines of: `Formatting /tmp/kraft-combined-logs`

3. Start KRaft, by running this command:

        kafka-server-start.sh /home/user/bin/kafka_2.13-3.8.0/config/kraft/server.properties

    There will be a lot of gibberish and the process will take over the terminal. The last line should contain `INFO [KafkaRaftServer nodeId=1] Kafka Server started (kafka.server.KafkaRaftServer)`.

# Stopping Kafka

* If running Kafka with Zookeeper, `Ctr+C` the terminal running Kafka, then `Ctr+C` the terminal running Zookeeper.

* If tunning Kafka with KRaft, , `Ctr+C` the terminal running KRaft.


