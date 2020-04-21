package test.demo.io;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author ghj
 * @Description
 * @date 2020/4/17 11:08
 */
public class BioClient {
    public static void main(String[] args) throws IOException {
        Socket socket;
        byte[] bs = new byte[1024];
        while (true) {
            socket = new Socket();
            socket.connect(new InetSocketAddress(9090));
            System.out.println("请输入：");
            Scanner sc = new Scanner(System.in);
            socket.getOutputStream().write(sc.nextLine().getBytes());
            System.out.println("已发送..");
            socket.getInputStream().read(bs);
            System.out.println(new String(bs));
        }
    }
}
