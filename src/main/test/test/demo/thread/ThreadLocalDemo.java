package test.dome.thread;

import test.dome.proxy.ProxyCGDome;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;

/**
 * @author ghj
 * @Description
 * @date 2020/4/14 10:58
 */
public class ThreadLocalDome {
    public static void main(String[] args) {
        ThreadLocal<Object> threadLocal = new ThreadLocal<>();
        threadLocal.set("t1");
        ThreadLocal<AtomicInteger> atomicIntegerThreadLocal = ThreadLocal.withInitial(new Supplier<AtomicInteger>() {
            private AtomicInteger tid = new AtomicInteger(0);

            @Override
            public AtomicInteger get() {
                return tid;
            }
        });
        System.out.println("--------------ThreadLocalMap-----------------");

        System.out.println(threadLocal.get());
        System.out.println("atomicIntegerThreadLocal = " + atomicIntegerThreadLocal.get());
    }
}
