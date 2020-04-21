package test.demo.proxy;

/**
 * @Author: ghj
 * @Date: 2020/4/13 21:42
 * @Version 1.0
 */
public class Student implements IPeople {
    public Integer num;
    private String name;
    @Override
    public void work() {
        System.out.println("student working.....");
    }

    @Override
    public void say(String text) {
        System.out.println("student: " + text
        );
    }
}
