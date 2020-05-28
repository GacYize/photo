package test.demo.thread;

/**
 * @author ghj
 * @Description
 * @date 2020/5/11 11:15
 */
public class WaitDemo {
    static final private Object obj = new Object();

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            for (int i = 50; i < 100; i++) {
                if (i == 60) {
                    synchronized (obj) {
                        try {
                            obj.wait();
                        } catch (InterruptedException e) {
                            System.err.println("中断异常");
                            e.printStackTrace();
                        }
                    }
                }
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }, "t1");
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                if (i == 20) {
                    synchronized (obj) {


                    }
                }
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }, "t2");
        t1.start();
        t2.start();
        //解除t1的等待
        t1.interrupt();
    }
}
