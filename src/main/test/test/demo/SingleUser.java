package test.demo;

import java.io.Serializable;

/**
 * 单例对象
 *
 * @author ghj
 * @Description
 * @date 2020/3/17 14:05
 */

public class SingleUser implements Serializable {
    private static final long serialVersionUID = 812956870439028042L;
    private String name;
    private Integer age;
    static private volatile SingleUser instance;

    private SingleUser() {
    }
    public static SingleUser getInstance() {
        if (instance == null) {
            synchronized (SingleUser.class) {
                System.err.println(Thread.currentThread().getName() + "待初始化");
                if (instance == null) {
                    instance = new SingleUser();
                    System.err.println(Thread.currentThread().getName() + "实例化对象");
                }
            }
        }
        return instance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "SingleUser{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
