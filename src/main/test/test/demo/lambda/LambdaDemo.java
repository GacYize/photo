package test.demo.lambda;


/**
 * @author ghj
 * @Description
 * @date 2020/3/18 15:05
 */
public class LambdaDemo {
    public static void main(String[] args) {
        StudyInterface studyInterface = new StudyInterface() {
            @Override
            public int add(int a, int b) {
                return a + b;
            }
        };
        System.out.println("studyInterface = " + studyInterface.add(1, 2));
        //lambda写法
        StudyInterface studyInterface1 = (a, b) -> {
            return a + b;
        };
        System.out.println("studyInterface1 = " + studyInterface1.add(2, 3));
        //lambda写法简化
        StudyInterface studyInterface2 = (a, b) -> a + b;
        System.out.println("studyInterface2 = " + studyInterface2.add(4, 5));

        //复制
        int[] arr = {1, 1, 1, 2, 23, 4, 55, 34, 5245, 36, 234, 234, 234, 234, 23, 42, 3423, 42, 342, 34, 235, 16, 547, 457, 4};
        int[] arr2 = new int[10];
        System.arraycopy(arr,3,arr2,0,10);
        for (int i : arr2) {
            System.out.println("i = " + i);
        }
        //移位操作
        int n=2;
        int v = n * 16;
        int v2 = n << 4;
        byte[] bytes = "abc".getBytes();
        for (byte aByte : bytes) {
            System.out.println("aByte = " + aByte);
        }
        System.out.println("binary:"+Integer.toBinaryString(4));
        System.out.println("v2 = " + v2);
        System.out.println("v = " + v);
    }
}
