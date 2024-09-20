package kafka;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.common.errors.WakeupException;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConsumerDemo {

    private static final Logger log = LoggerFactory.getLogger(ConsumerDemo.class.getSimpleName());

    public static void main(String[] args) {
        log.info("I am a Kafka Consumer!");

        String groupId = "my-java-application";
        String topic = "demo_java";

        // create Consumer Properties
        Properties properties = new Properties();

        // connect to localhost
        properties.setProperty("bootstrap.servers", "127.0.0.1:9092");

        // set consumer properties (deserializer converts bytestreams to strings)
        properties.setProperty("key.deserializer", StringDeserializer.class.getName());
        properties.setProperty("value.deserializer", StringDeserializer.class.getName());

        properties.setProperty("group.id", groupId);

        // this property has three possible values:
        // none - if there is no consumer group, then program will fail
        // earliest - read from the beginning
        // latest - read from when the consumer is started
        properties.setProperty("auto.offsett.reset", "earliest");
        
        // create the Consumer
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(properties);

        // get a reference to the main thread
        final Thread mainThread = Thread.currentThread();

        // add a shutdown hook
        Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run() {
                log.info("Shutdown detected");
                // throw wakeup exception
                consumer.wakeup();

                // join the main thread
                try {
                    mainThread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        
        try {
            // subscribe to topics (add aditional topics separated by comma)
            consumer.subscribe(Arrays.asList(topic));

            // poll for data
            while (true){
                log.info("Polling");
                
                ConsumerRecords<String, String> records =
                    consumer.poll(Duration.ofMillis(100));

                for (ConsumerRecord<String, String> record:records) {
                    log.info("Key: " +record.key() + ", Value: " +record.value());
                    log.info("Partition: " +record.partition() + ", Offset: " +record.offset());
                }
            }
        } catch (WakeupException e){ // since this is what the shutdown hook throws
            log.info("Shutting down...");
        } catch (Exception e) {
            log.error("Unexpected exception", e);
        } finally {
            consumer.close();
            log.info("The consumer was shut down gracefullly");
        }
    }
}
