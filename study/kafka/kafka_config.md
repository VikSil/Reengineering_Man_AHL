_This document is a collection of guidelines an notes taken while learning Apache Kafka. Mostly intended for the author's own use._

# Configuration

Check these two files in Kafka's `config` directory:

* /config/zookeeper.properties
* config/server.properties

Both stash data and logs into root `/tmp` folder by default.


## Server Properties

* Number of default partitions for new topics

    num.partitions=3