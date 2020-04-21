package test.demo.clone;

import lombok.Data;

/**
 * @author ghj
 * @Description
 * @date 2020/4/15 16:35
 */
@Data
public class Person implements Cloneable{
    private String type;

    private String work;

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }


}
