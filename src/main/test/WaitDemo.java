import java.util.HashMap;

/**
 * @Author: ghj
 * @Date: 2020/4/1 20:32
 * @Version 1.0
 */
public class WaitDemo {
    public static void main(String[] args) throws InterruptedException {
        String str = new String("aaa");
        Object obj = new Object();
        new Thread(()->{
            for (int i = 0; i < 20; i++) {
                synchronized (obj) {
                    System.out.println(i + str);
                    if (i == 10) {
                        try {
                            obj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
//                obj.notify();
                }

            }
        }).start();

        new Thread(() -> {
            synchronized (obj){
                for (int i = 0; i < 3; i++) {
                    System.out.println("t1_" + i);
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                obj.notify();
            }

        }).start();
    }



}
