import java.util.HashMap;
import java.util.Map;

/**
 * @Author: ghj
 * @Date: 2020/2/20 20:42
 * @Version 1.0
 */
public class Demo2 {
    public static void main(String[] args) {
        Double a = 0.01;
        Double b = 0.0;
        Double sum = 0.0;
        for (int i = 0; i < 30; i++) {
            b = 2 * a;
            sum += b;
            a = b;
        }
        double round = Math.round(sum);
        long count = new Double(round).longValue();
        System.out.println("b = " + b);
        System.out.println("sum = " + sum);
        System.out.println("sum2 = " + count);

        Map<String,String> map=new HashMap<>();
        map.put("name","张三");
    }
}
