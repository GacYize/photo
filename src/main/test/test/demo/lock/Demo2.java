package test.demo.lock;

import org.junit.Test;

/**
 * @author ghj
 * @Description
 * @date 2020/3/13 16:03
 */
public class Demo2 {
    static volatile private int num = 100;
    private final static Object o = new Object();

    public static void main(String[] args) {
        new Thread(() -> {
            while (true) {
                synchronized (o) {
                    if (num <= 0) {
                        break;
                    }
                    pay();
                }
            }
        }, "T1").start();

        new Thread(() -> {
            while (true) {
                synchronized (o) {
                    if (num <= 0) {
                        break;
                    }
                    pay();
                }
            }
        }, "T2").start();
    }

    @Test
    public void IntDome() {
        new Thread(() -> {
            while (true) {
                synchronized (o) {
                    if (num <= 0) {
                        break;
                    }
                    pay();
                }
            }
        }, "T1").start();

        new Thread(() -> {
            while (true) {
                synchronized (o) {
                    if (num <= 0) {
                        break;
                    }
                    pay();
                }
            }
        }, "T2").start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void pay() {
        System.out.println(Thread.currentThread().getName() + " number：" + num);
        num--;
    }

    @Test
    public void testPay() {
        while (true) {
            synchronized (o) {
                if (num <= 0) {
                    break;
                }
                pay();
            }
        }
    }
}
