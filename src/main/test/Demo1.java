/**
 * @Author: ghj
 * @Date: 2020/2/11 11:50
 * @Version 1.0
 */
public class Demo1 {
    public static void main(String[] args) {
        Byte a = 100;
        Integer b = 100;
        Integer c = 100;
        long d = 999;
        String str = "";
        System.out.println("a.equals((byte)100) = " + a.equals((byte) 100));
        System.out.println(a == 100);
        System.out.println(b.equals(10));
        System.out.println(b == 10);
        System.out.println(b == c);
        System.out.println(Math.abs(c));
        System.out.println("Math.abs(d) = " + Math.abs(d));
        System.out.println("c.equals(a) = " + c.equals(a));
        System.out.println(c == a.intValue());
        System.out.println("c.equals(a) = " + c.equals(a.intValue()));
        System.out.println(c == a.intValue());
        System.out.println("String.valueOf(d) = " + String.valueOf(d));
        System.out.println("str.length() = " + str.length());

        System.out.println("----------------");
        Integer a1 = -100;
        System.out.println("Integer.toBinaryString(100) = " + Integer.toBinaryString(100));
        System.out.println("Integer.toBinaryString(-100) = " + Integer.toBinaryString(-100));
        System.out.println((-100) >>> 1);
        System.out.println((-100) >> 1);
    }
}
