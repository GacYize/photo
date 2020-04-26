package kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author ghj
 * @Description
 * @date 2020/4/26 15:15
 */
public class ProducerDemo {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        FileInputStream inputStream = new FileInputStream("D:\\IdeaProjects\\alice-photo\\src\\main\\test\\kafka\\producer.properties");
        properties.load(inputStream);
        KafkaProducer<Object, Object> producer = new KafkaProducer<>(properties);
        for (int i = 0; i < 100; i++) {
            ProducerRecord producerRecord = new ProducerRecord("topic_1", "demo", "hello_" + i);
            producer.send(producerRecord, (metadata, exception) -> {
                if (metadata != null) {
                    System.out.println("metadata.topic() = " + metadata.topic());
                    System.out.println("metadata.offset() = " + metadata.offset());
                    System.out.println("metadata.partition() = " + metadata.partition());
                }
            });
        }
        producer.close();
    }
}
