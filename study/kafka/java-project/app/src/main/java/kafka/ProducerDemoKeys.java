package kafka;

import java.util.Properties;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProducerDemoKeys {

    private static final Logger log = LoggerFactory.getLogger(ProducerDemoKeys.class.getSimpleName());

    public static void main(String[] args) {
        log.info("I am a Kafka Producer!");

        // create Producer Properties
        Properties properties = new Properties();

        // connect to localhost
        properties.setProperty("bootstrap.servers", "127.0.0.1:9092");

        // set producer properties (serializer expects strings to convert into bytestream)
        properties.setProperty("key.serializer", StringSerializer.class.getName());
        properties.setProperty("value.serializer", StringSerializer.class.getName());

        // create the Producer
        KafkaProducer<String, String> producer = new KafkaProducer<>(properties);

        String topic = "demo_java";

        // run twice to demonstrate that
        // messages with the same keys
        // go to the same partitions
        for (int j =0; j<2; j++) {
        
            // generate multiple messages

            for (int i = 0; i<10; i++){

                String key = "id_"+i;
                String value = "This is " + i+". message";

                // create a Producer Record
                ProducerRecord<String, String> producerRecord = 
                new ProducerRecord<>(topic,key,value);

                // send data
                producer.send(producerRecord, new Callback() {
                @Override
                public void onCompletion(RecordMetadata metadata, Exception e) {
                    // execute every time a record is sent
                    if (e == null) {
                        log.info("Key: " + key + " | " +
                        "Partition: " + metadata.partition() + "\n" );
                    }
                    else {
                        log.error("Error occured during message production", e);
                    }
                }
                });
            }
        }
        
        // flush and close the producer
        producer.flush(); // sends the data to kafka and waits until done
        producer.close();
    }
}
