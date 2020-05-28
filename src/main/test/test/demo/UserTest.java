package test.demo;

import java.util.Objects;

/**
 * @author ghj
 * @Description
 * @date 2020/3/12 8:55
 */
public class UserTest {

    public static void main(String[] args) {
        UserDome userDome = new UserDome(10);
        UserDome userDome1 = new UserDome(10);
        System.out.println("userDome1.equals(userDome) = " + userDome1.equals(userDome));
    }


    static class UserDome {
        private Integer age;
        private String name;

        public UserDome(Integer age) {
            this.age = age;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            UserDome userDome = (UserDome) o;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return Objects.equals(age, userDome.age) &&
                    Objects.equals(name, userDome.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(age, name);
        }

        @Override
        public String toString() {
            return "UserTest{" +
                    "age=" + age +
                    '}';
        }
    }
}
