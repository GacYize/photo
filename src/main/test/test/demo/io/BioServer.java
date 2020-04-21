package test.demo.io;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author ghj
 * @Description
 * @date 2020/4/17 10:50
 */
public class BioServer {
    public static void main(String[] args) throws IOException {
        byte[] bs = new byte[1024];

        ServerSocket serverSocket = new ServerSocket();
        serverSocket.bind(new InetSocketAddress(9090));
        while (true) {
            System.out.println("等待连接...");
            //accept负责跟客户端通信
            Socket accept = serverSocket.accept();//阻塞   释放cpu资源
            System.out.println("连接成功！！！");
                System.out.println("等待数据的发送...");
                int read = accept.getInputStream().read(bs);//阻塞  --无法并发的主要原因（连接socket但是不发送数据）
                System.out.println("读取到数据 长度：" + read);
                System.out.println("接收到数据：" + new String(bs));
                accept.getOutputStream().write("发送成功".getBytes());
            }
        }
    }
