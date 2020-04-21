package test.dome.lock;

import org.junit.Test;
import org.springframework.util.CollectionUtils;
import redis.clients.jedis.Jedis;
import test.dome.LocalJedis;

import javax.ejb.Local;
import javax.rmi.CORBA.Util;
import javax.servlet.jsp.jstl.fmt.LocaleSupport;
import java.io.IOException;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @author ghj
 * @Description
 * @date 2020/2/28 10:48
 */
public class Dome1 {
    enum TestEnum {T1, T2}

    TestEnum d = TestEnum.T1;

    @Test
    public void test1() {
        Jedis jedis = new Jedis("127.0.0.1", 6380);
        jedis.get("demo");
        jedis.close();
    }

    @Test
    public void test2() throws IOException {
        LocalJedis localJedis = new LocalJedis("127.0.0.1", 6379);
        String set = localJedis.set("name2", "hello");
        String value = localJedis.get("name2");
        System.out.println(value);
    }


    Thread T1 = null, T2 = null;

    @Test
    public void volatileDemo() {
        char[] charNum = "123456".toCharArray();
        char[] charStr = "ABCDEFG".toCharArray();
        T1 = new Thread(() -> {
            for (char c : charNum) {
                System.out.print(c);
                LockSupport.unpark(T2);
                LockSupport.park();
            }

        }, "T1");
        T2 = new Thread(() -> {
            for (char c : charStr) {
                LockSupport.park();
                System.out.print(c + "_");
                LockSupport.unpark(T1);
            }

        }, "T2");
        System.out.println("T1.getState：" + T1.getState());
        T1.start();
        System.out.println("T1.getState：" + T1.getState());
        T2.start();
        System.out.println("T1.getState：" + T2.getState());
    }

    volatile private int num = 100;

    @Test
    public void IntDome() {
        new Thread(() -> {
                while (true) {
                    synchronized (this) {
                    if (num <= 0) {
                        break;
                    }
                    pay();
                }
            }
        }, "T1").start();

        new Thread(() -> {
                while (true) {
                    synchronized (this) {
                    if (num <= 0) {
                        break;
                    }
                    pay();
                }
            }
        }, "T2").start();
    }

    public synchronized void pay() {
        System.out.println(Thread.currentThread().getName() + " number：" + num);
        num--;
    }

    @Test
    public void test3() {
        while (true) {
            if (num <= 0) {
                break;
            }
            pay();
        }
    }

}
