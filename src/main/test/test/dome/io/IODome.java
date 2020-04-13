package test.dome.io;

import java.io.*;

/**
 * @author ghj
 * @Description
 * @date 2020/3/19 11:03
 */
public class IODome {
    public static void main(String[] args) throws IOException {
        File file = new File("d:\\Pictures\\德玛.jpg");
        FileInputStream is = new FileInputStream(file);
        byte[] b = new byte[1024];
        File targetFile = new File("d:\\Pictures\\新建文件夹","aa1.jpg");
        FileOutputStream os = new FileOutputStream(targetFile);
        int length;
        while ((length = is.read(b)) > 0) {
            os.write(b, 0, length);
        }
        os.close();
        is.close();
    }
}
