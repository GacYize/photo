package test.demo.anno;

import java.io.Serializable;

/**
 * @author ghj
 * @Description
 * @date 2020/4/15 15:33
 */
public class PersonDemo implements Serializable {
    private static final long serialVersionUID = -8382096208022262655L;
    @AnnoDemo(age = 2, name = "zhangsan")
    private String student;

    public String getStudent() {
        return student;
    }
}
