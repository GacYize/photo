package test.dome.executor;

import java.util.concurrent.*;

/**
 * @author ghj
 * @Description
 * @date 2020/3/19 9:52
 */
public class ExecutorsDome {
    public static void main(String[] args) {
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(8);
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
        ThreadPoolExecutor threadPoolExecutor =
                new ThreadPoolExecutor(2, 3, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(10));


    }
}
