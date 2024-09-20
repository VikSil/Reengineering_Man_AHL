package kafka;

import java.util.Properties;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.clients.producer.RoundRobinPartitioner;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProducerDemoWithCallback {

    private static final Logger log = LoggerFactory.getLogger(ProducerDemoWithCallback.class.getSimpleName());

    public static void main(String[] args) {
        log.info("I am a Kafka Producer!");

        // create Producer Properties
        Properties properties = new Properties();

        // connect to localhost
        properties.setProperty("bootstrap.servers", "127.0.0.1:9092");

        // set producer properties (serializer expects strings to convert into bytestream)
        properties.setProperty("key.serializer", StringSerializer.class.getName());
        properties.setProperty("value.serializer", StringSerializer.class.getName());

        // Uncomment to force Round Robbin partitioning
        // properties.setProperty("partitioner.class", RoundRobinPartitioner.class.getName());

        // Uncomment to control batch size (default is 16 KB)
        // properties.setProperty("batch.size", "400");

        // create the Producer
        KafkaProducer<String, String> producer = new KafkaProducer<>(properties);

        // generate multiple messages
        // this will use StickyPartitioner, i.e.
        // all messages will go to the same partition as a batch
        // partitioner.class = null
        for (int i = 0; i<10; i++){
            // create a Producer Record
            ProducerRecord<String, String> producerRecord = 
            new ProducerRecord<>("demo_java", i+". message");

            // send data
            producer.send(producerRecord, new Callback() {
            @Override
            public void onCompletion(RecordMetadata metadata, Exception e) {
                // execute every time a record is sent
                if (e == null) {
                    log.info("Received new metadata \n" +
                    "Topic: " + metadata.topic() + "\n" +
                    "Partition: " + metadata.partition() + "\n" +
                    "Offset: " + metadata.offset() + "\n" +
                    "Timestamp: " + metadata.timestamp() + "\n" );
                }
                else {
                    log.error("Error occured during message production", e);
                }
            }
            });

        }
        
        // flush and close the producer
        producer.flush(); // sends the data to kafka and waits until done
        producer.close();
    }
}
