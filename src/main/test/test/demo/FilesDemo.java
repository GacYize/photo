package test.dome;




import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author ghj
 * @Description
 * @date 2020/3/25 13:30
 */
public class FilesDome {
    public static void main(String[] args) throws IOException {
        //Files工具进行IO复制
        String input="d:\\Pictures\\德玛.jpg";
        String output="d:\\Pictures\\新建文件夹";
        Files.copy(Paths.get(input),Paths.get(output,"aaaaaa.jpg"));
        //读取
        Files.lines(Paths.get(output,"dome.txt")).forEach(line->{
//            JSON.parse(line)
            System.out.println(line);
        });
    }
}
