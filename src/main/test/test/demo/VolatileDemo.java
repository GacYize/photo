package test.demo;

/**
 * @author ghj
 * @Description
 * @date 2020/3/17 11:17
 */
public class VolatileDemo {
    static volatile int a = 0;

    void add() {
        a++;
    }

    int get() {
        return a;
    }

    public static void main(String[] args) {
//        VolatileDome v = new VolatileDome();
//        for (int i = 0; i < 10000; i++) {
//            v.add();
//        }
        new Thread(() -> {
//            for (int i = 0; i < 10000; i++) {
//                v.add();
//            }
            System.out.println(a + "t1");
            a++;
        }).start();

        new Thread(() -> {
            System.out.println(a + "t2");
            a++;
        }).start();
        System.out.println(a);
    }
}
