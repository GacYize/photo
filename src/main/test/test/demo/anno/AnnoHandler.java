package test.demo.anno;

import java.lang.reflect.Field;

/**
 * @author ghj
 * @Description
 * @date 2020/4/15 15:34
 */
public class AnnoHandler {
    public static void getInfo(Class<?> clzz) {
        StringBuilder sb = new StringBuilder();
        Field[] declaredFields = clzz.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            if (declaredField.isAnnotationPresent(AnnoDemo.class)) {
                AnnoDemo annotation = declaredField.getAnnotation(AnnoDemo.class);
               sb.append("年龄：").append(annotation.age()).append(" 姓名：").append(annotation.name());
                System.out.println(sb);
            }
        }
    }
}
