package test.demo.clone;


import lombok.Data;

/**
 * @author ghj
 * @Description
 * @date 2020/4/15 16:23
 */
@Data
public class Student implements Cloneable {
    private String name;

    private Integer age;

    private Person p;

    //深克隆
    public Object deepClone() {
        Student o = null;
        try {
            o = (Student) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        try {
            o.p = (Person) p.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return o;
    }

    public Object shallowClone() {
        try {
            return (Student)super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
//        try {
//            o.personDome = (PersonDome) super.clone();
//        } catch (CloneNotSupportedException e) {
//            e.printStackTrace();
//        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", personDome=" + p +
                '}';
    }
}
