package test.dome.lock;

import java.util.concurrent.CountDownLatch;

/**
 * @author ghj
 * @Description
 * @date 2020/4/8 14:37
 */
public class AQSDome {
    private static volatile Integer num = 0;//volatile只保证变量的可见性，不保证原子性
    private static CountDownLatch latch = new CountDownLatch(100);

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[100];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 100; j++) {
                    num++;
                }
            });
//            latch.countDown();
        }
        for (Thread thread : threads) {
            thread.start();
        }
        for (Thread thread : threads) {
            //等待所有线程执行完
            thread.join();
        }
//        latch.await();
        System.out.println("num = " + num);
    }
}
