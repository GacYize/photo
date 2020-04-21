package test.demo.proxy;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author ghj
 * @Description
 * @date 2020/4/15 14:53
 */
public class ReflectDemo {
    public static void main(String[] args) throws Exception {
        Class<?> clazz = Class.forName("test.demo.proxy.Student");
        System.out.println("clazz.getDeclaredField(\"num\") = " + clazz.getDeclaredField("num"));
        System.out.println("clazz.getTypeName() = " + clazz.getTypeName());
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            System.out.println("method = " + method);
        }
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            System.out.println("field = " + field);
        }
        Student student = (Student) clazz.newInstance();
        System.out.println(student);
        Field[] clazzFields = clazz.getFields();
        for (Field clazzField : clazzFields) {
            System.out.println("clazzField = " + clazzField);
        }
    }
}
