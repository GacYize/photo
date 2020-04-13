package test.dome;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author ghj
 * @Description
 * @date 2020/3/17 10:36
 */
public class AtomicDome {
    static class A {
        volatile AtomicInteger a = new AtomicInteger(0);

        void add() {
            a.addAndGet(1);
        }

        int get() {
            return a.get();
        }
    }

    static AtomicInteger a = new AtomicInteger(0);

    void add() {
        for (int i = 0; i < 10000; i++) {
            a.incrementAndGet();
        }
    }

    public static void main(String[] args) {
        AtomicDome vd = new AtomicDome();
        List<Thread> threadList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            threadList.add(new Thread(vd::add, "thread-" + i));
        }
        threadList.stream().forEach(thread -> thread.start());
        threadList.stream().forEach(thread -> {
            try {
                thread.join();//main线程放弃执行权交给其他线程，其他线程跑完再执行main线程
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println(a.get());

    }

}
