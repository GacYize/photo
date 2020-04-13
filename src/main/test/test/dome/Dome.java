package test.dome;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/**
 * @author ghj
 * @Description
 * @date 2020/3/30 11:04
 */
public class Dome {
    public static void main(String[] args) {
        Long a = 9L;
        Long b = 900L;
        System.out.println(a.compareTo(b));
        System.out.println(b.compareTo(a));
        float f = 9.1F;
        //相同的hashcode
        String str1 = "通话";
        String str2 = "重地";
        System.out.println(String.format("str1：%d | str2：%d", str1.hashCode(), str2.hashCode()));
        System.out.println(str1.equals(str2));
        System.out.println(Math.round(-53.5));
        System.out.println(1.12345672F);
        short s1 = 1;
        s1 = (short) (s1 + 1);
        s1 += 1;
    }

    @Test
    public void test1() throws InterruptedException {
        Integer f1 = 100, f2 = 100, f3 = 150, f4 = 150;
        Integer a = 200;
        Integer b = 200;
        System.out.println(a == b);
        //int值在 -18--127不用创建新对象，直接到常量池获取
        System.out.println(f1 == f2);
        System.out.println(f3 == f4);
        if (m1() | m2()) {
            System.out.println("------------");
        }
        if (m1() || m2()) {

        }
        byte[] bytes = new byte[1024 * 1024 * 1000];
        Thread.sleep(1000 * 60);
        byte c = 10;
        switch (c) {
            case 1: {
                System.out.println();
            }
            break;

        }

    }

    public boolean m1() {
        System.out.println("1111");
        return true;
    }

    public void m1(int a) {

    }

    public boolean m2() {
        System.out.println("222");
        return false;
    }

    public String reverse(String str) {
        if (str == null || str.length() <= 1) {
            return str;
        }else {
            String reverse = reverse(str.substring(1));
            return reverse+str.charAt(0);
        }
    }

    @Test
    public void test2() throws UnsupportedEncodingException {
        System.out.println("Integer.toBinaryString(100) = " + Integer.toBinaryString(100));
        System.out.println("Integer.toBinaryString(128) = " + Integer.toBinaryString(128));
    }
}
