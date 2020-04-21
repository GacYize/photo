package test.demo.clone;

/**
 * @author ghj
 * @Description
 * @date 2020/4/15 16:36
 */
public class Test {
    public static void main(String[] args) {
        Student student = new Student();
        student.setAge(100);
        student.setName("王五");
        Person person = new Person();
        person.setType("医生");
        person.setWork("手术");
        student.setP(person);
        System.out.println("student = " + student);
        Student shallowClone = (Student) student.shallowClone();
        System.out.println("shallowClone = " + shallowClone);
        Student studentClone = (Student) student.deepClone();
        System.out.println("studentClone = " + studentClone);
        System.err.println("*********************************");
        person.setType("科学家");
        person.setWork("科研工作");
        student.setP(person);
        Student shallowClone1 = (Student) student.shallowClone();
        System.out.println("shallowClone1 = " + shallowClone1);
        Student studentClone1 = (Student) student.deepClone();
        System.out.println("studentClone1 = " + studentClone1);
    }
}
