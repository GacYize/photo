package test.demo.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ghj
 * @Description
 * @date 2020/4/2 12:23
 */
public class ReentrantLockDemo1 {
    public static void main(String[] args) {
        Object obj=new Object();
        ReentrantLock reentrantLock = new ReentrantLock();
        new Thread(()->{
            reentrantLock.lock();
            System.out.println(Thread.currentThread().getName()+"执行...");
            reentrantLock.unlock();
        },"t1").start();
        new Thread(()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            reentrantLock.lock();
            System.out.println(Thread.currentThread().getName()+" 执行...");
            reentrantLock.unlock();
        },"t2").start();
        new Thread(()->{
            try {
                Thread.sleep(1300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            reentrantLock.lock();
            System.out.println(Thread.currentThread().getName()+" 执行...");
            reentrantLock.unlock();
        },"t3").start();
        new Thread(()->{
            try {
                Thread.sleep(1200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            reentrantLock.lock();
            System.out.println(Thread.currentThread().getName()+" 执行...");
            reentrantLock.unlock();
        },"t4").start();
    }
}
