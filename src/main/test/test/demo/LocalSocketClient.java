package test.demo;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author ghj
 * @Description
 * @date 2020/3/24 9:36
 */
public class LocalSocketClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 8080);
        OutputStream os = socket.getOutputStream();
        PrintWriter printWriter = new PrintWriter(os);
        int tag = 0;
        while (true) {
            System.out.println("请输入");
            Scanner scanner = new Scanner(System.in);
            printWriter.write(scanner.nextLine());
            printWriter.flush();
            tag++;
        }
//        os.close();
//        socket.close();
    }
}
