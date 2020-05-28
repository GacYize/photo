package test.demo;

import com.alice.photo.model.TUser;

/**
 * @author ghj
 * @Description
 * @date 2020/3/26 15:23
 */
public class StringBufferDemo {
    public static void main(String[] args) {
//        StringBuffer sb = new StringBuffer();
//        StringBuilder sb=new StringBuilder();
//        sb.append("abc");
//        new Thread(() -> {
//            sb.append("123");
//            System.out.println("t1：" + sb);
//        }).start();
//        new Thread(() -> {
//            sb.append("999");
//            System.out.println("t2：" + sb);
//        }).start();
//        System.out.println("main；" + sb);
        String str1 = "aa";
        String str2 = "aa";
        System.out.println(str1.hashCode());
        System.out.println(str2.hashCode());
        System.out.println("aa".hashCode());
        String str3 = new String("aa");
        System.out.println(str3.hashCode());
        System.out.println("str1.equals(str2) = " + str1.equals(str2));
//        System.out.println(str1 == str2);
//        System.out.println("str1.equals(str3) = " + str1.equals(str3));
//        System.out.println(str2 == str3);
//        System.out.println("System.identityHashCode(str2) = " + System.identityHashCode(str2));
//        System.out.println("System.identityHashCode(str1) = " + System.identityHashCode(str1));
//        System.out.println("System.identityHashCode(str3) = " + System.identityHashCode(str3));
//        System.out.println("System.identityHashCode(aa) = " + System.identityHashCode("aa"));
        System.out.println(Math.abs(50 % 3));


        TUser tUser = new TUser();
        tUser.setId(1).setEmail("aaa");

    }


}
