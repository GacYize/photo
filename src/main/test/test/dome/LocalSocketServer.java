package test.dome;

import org.junit.Test;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author ghj
 * @Description
 * @date 2020/3/6 14:34
 */
public class LocalSocketServer {
    //阻塞的io

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(6380);
        Socket socket = null;
        int tag = 0;
        byte[] bs = new byte[1024];
        while (tag < 5) {
            System.out.println("等待连接...");
            socket = serverSocket.accept();//阻塞
            System.out.println("已连接，等待接收数据...");
            int length = socket.getInputStream().read(bs);//阻塞
            socket.getOutputStream().write("请求成功".getBytes());//阻塞
            while (length != 0) {
                System.out.println(new String(bs));
            }
            tag++;
        }
        OutputStream outputStream = socket.getOutputStream();//获取一个输出流，向服务端发送信息
        PrintWriter printWriter = new PrintWriter(outputStream);//将输出流包装成打印流
        printWriter.print("你好，服务端已接收到您的信息");
        printWriter.flush();
        socket.shutdownOutput();//关闭输出流
        socket.close();
        serverSocket.close();
    }


}
