package test.demo.collection;


import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author ghj
 * @Description
 * @date 2020/3/26 14:09
 */
public class MapDemo {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Map<String, String> map = new ConcurrentHashMap<>(10);
        map.put("name", "wangwu");
        map.put("name", "zhangsan");
        Map<Integer, String> map1 = new HashMap<>();
        map1.put(1, "aa");
        String str = "hello ";
        System.out.println(str);
        Field field = String.class.getDeclaredField("value");
        field.setAccessible(true);
        char[] arr = (char[]) field.get(str);
        arr[5] = '!';
        System.out.println(str);
        StringBuffer sb = new StringBuffer();
        StringBuilder stringBuilder = new StringBuilder();
        /*********************/
        String s = "wangwu";

//        System.out.println("s.hashCode() = " + s.hashCode());
//        System.out.println("Integer.valueOf(s.hashCode()). = " + Integer.toBinaryString(s.hashCode()));
//
//        System.out.println("Integer.valueOf(s.hashCode())>>16 = " + Integer.toBinaryString(s.hashCode() >> 16));
        System.out.println(Integer.toBinaryString(125));
        if (s.length() >= 6)
            System.out.println(Integer.toBinaryString(125 >> 6));//1111
        else {
            System.out.println("========");
        }
    }
}
