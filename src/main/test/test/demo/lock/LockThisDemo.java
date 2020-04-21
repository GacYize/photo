package test.dome.lock;

/**
 * @author ghj
 * @Description
 * @date 2020/4/8 14:48
 */
public class LockThisDome {
    public static void main(String[] args) {
        new Thread(() -> {
            Main main = new Main();
            System.out.println(Thread.currentThread().getName() + "执行...");
//            try {
//                Thread.sleep(1000 * 2);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            main.set();
        }).start();
        new Thread(() -> {
            Main main = new Main();

            main.set();
        }).start();
    }

    static class Main {
        volatile int a = 0;

        public synchronized void run() {
            a++;
            System.out.println(Thread.currentThread().getName() +" :"+ a);
        }

        public  void set() {
            synchronized (Main.class){
                a++;
                System.out.println(Thread.currentThread().getName() +" :"+ a);
                try {
                    Thread.sleep(1000*3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

        }
    }
}
