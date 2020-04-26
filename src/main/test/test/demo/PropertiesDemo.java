package test.demo;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

/**
 * @author ghj
 * @Description
 * @date 2020/4/26 14:51
 */
public class PropertiesDemo {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        FileInputStream inputStream = new FileInputStream("D:\\IdeaProjects\\alice-photo\\src\\main\\test\\test\\demo\\testData.properties");
        properties.load(inputStream);
//        properties.put("name","test");
//        System.out.println(properties.get("name"));
        for (Map.Entry<Object, Object> entry : properties.entrySet()) {
            System.out.println("key:" + entry.getKey() + " value：" + entry.getValue());
        }

    }
}
