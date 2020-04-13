package test.dome;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

/**
 * @author ghj
 * @Description
 * @date 2020/3/6 14:34
 */
public class LocalSocketServerNIO {
    //阻塞的io

    public static void main(String[] args) throws IOException {
        //打开Selector为了它可以轮询每个 Channel 的状态
        Selector selector = Selector.open();
        ServerSocketChannel ssc = ServerSocketChannel.open();
        ssc.configureBlocking(false);//设置为非阻塞方式
        ssc.socket().bind(new InetSocketAddress(6380));
        ssc.register(selector, SelectionKey.OP_ACCEPT);//注册监听的事件
        ServerSocket serverSocket = ssc.socket();
        int tag = 0;
        while (tag < 10) {
            Socket accept = serverSocket.accept();
            InputStream is = accept.getInputStream();
            InputStreamReader reader = new InputStreamReader(is);
            BufferedReader bufferedReader = new BufferedReader(reader);
            while (bufferedReader.readLine() != null) {
                System.out.println("接到到客服端信息：" + bufferedReader.readLine());
            }
            tag++;
        }
        serverSocket.close();
    }


}
