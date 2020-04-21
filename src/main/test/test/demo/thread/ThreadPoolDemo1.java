package test.demo.thread;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author ghj
 * @Description
 * @date 2020/4/13 11:08
 */
public class ThreadPoolDemo1 {
    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor.CallerRunsPolicy callerRunsPolicy = new ThreadPoolExecutor.CallerRunsPolicy();
        ThreadPoolExecutor threadPoolExecutor =
                new ThreadPoolExecutor(4, 10, 1,
                        TimeUnit.SECONDS, new LinkedBlockingQueue<>(2), callerRunsPolicy);
        long start = System.currentTimeMillis();
        TaseDome taseDome = new TaseDome();
        Thread[] threads = new Thread[15];
        for (Thread thread : threads) {
            thread = new Thread(taseDome);
            threadPoolExecutor.execute(thread);
        }
        System.out.println("threadPoolExecutor.getActiveCount() = " + threadPoolExecutor.getActiveCount());
        if (threadPoolExecutor.isShutdown()) {
            long end = System.currentTimeMillis();
            System.out.println("耗时：" + (end - start) / 1000);
        }

    }

    static class TaseDome implements Runnable {
        @Override
        public void run() {
            try {
//                Thread.sleep(2000);
                System.out.println(Thread.currentThread().getName() + "执行");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
