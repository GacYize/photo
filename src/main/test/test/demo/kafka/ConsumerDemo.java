package test.demo.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.TopicPartition;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

/**
 * @author ghj
 * @Description
 * @date 2020/4/26 16:04
 */
public class ConsumerDemo {
    public static void main(String[] args) throws IOException {
        final KafkaConsumer<Object, Object> consumer;
        Properties properties = new Properties();
        FileInputStream inputStream = new FileInputStream("D:\\IdeaProjects\\alice-photo\\src\\main\\test\\test\\demo\\testData.properties");
        properties.load(inputStream);
        consumer = new KafkaConsumer<>(properties);
        TopicPartition topic_1 = new TopicPartition("topic_1", 1);
        consumer.beginningOffsets(Arrays.asList(topic_1));
        //开启一个jvm关闭的守护线程，释放consumer资源
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            consumer.close();
        }));
        while (true) {
            ConsumerRecords<Object, Object> records = consumer.poll(Duration.ofMillis(10));
            for (ConsumerRecord<Object, Object> record : records) {
                System.out.println("record.offset() = " + record.offset());
                System.out.println("record.partition() = " + record.partition());
            }
        }
    }
}
