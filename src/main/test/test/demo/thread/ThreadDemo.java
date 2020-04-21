package test.dome.thread;

import java.io.Serializable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author ghj
 * @Description
 * @date 2020/3/9 11:19
 */
public class ThreadDome_1 {
    private static char[] charNum = "1234567".toCharArray();
    private static char[] charStr = "ABCDEFG".toCharArray();
    private static volatile boolean flag = true;
    private static CountDownLatch countDownLatch = new CountDownLatch(1);
    private final static Object o = new Object();

    public static void main(String[] args) throws InterruptedException {

        new Thread(() -> {
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (o) {
                for (char c : charStr) {
                    System.out.print(c);

//                    flag = false;
                    o.notify();
                    try {
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                o.notify();
            }
        }, "T2").start();

        new Thread(() -> {
            synchronized (o) {
//                try {
//                    countDownLatch.await();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                while (flag) {
//                    try {
//                        o.wait();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
                for (char c : charNum) {
                    System.out.print(c);
                    countDownLatch.countDown();
                    System.out.println("交给T2");
                    o.notify();
                    try {
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                o.notify();
            }
        }, "T1").start();

    }
}
