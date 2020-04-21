package test.demo;

/**
 * @author ghj
 * @Description
 * @date 2020/3/17 14:10
 */
public class SingleDemo {
    public static void main(String[] args) {

        new Thread(() -> {

            SingleUser singleUser = SingleUser.getInstance();
            singleUser.setName("王二");
            singleUser.setAge(18);
            System.out.println(singleUser);
        }, "t1").start();
        new Thread(() -> {
            SingleUser singleUser = SingleUser.getInstance();
            singleUser.setName("张三");
            singleUser.setAge(30);
            System.out.println(singleUser);
        }, "t2").start();



    }
}
