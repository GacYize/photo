package test.demo.kafka;

import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.TopicPartition;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;

/**
 * @author ghj
 * @Description
 * @date 2020/4/26 16:04
 */
public class ConsumerDemo {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        FileInputStream inputStream = new FileInputStream("D:\\IdeaProjects\\alice-photo\\src\\main\\test\\test\\demo\\testData.properties");
        properties.load(inputStream);
        KafkaConsumer<Object, Object> consumer = new KafkaConsumer<>(properties);
        TopicPartition topic_1 = new TopicPartition("topic_1", 1);
        consumer.subscribe(Arrays.asList("topic_1"));
    }
}
