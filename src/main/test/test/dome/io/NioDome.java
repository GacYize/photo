package test.dome.io;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @author ghj
 * @Description
 * @date 2020/3/19 10:54
 */
public class NioDome {
    public static void main(String[] args) throws IOException {
        // 0.创建选择器
        Selector sele = Selector.open();
        //1.创建服务器
        ServerSocketChannel ssc = ServerSocketChannel.open();
        ssc.bind(new InetSocketAddress("127.0.0.1", 8080));
        // 2.设置ssc为非阻塞
        ssc.configureBlocking(false);
        // 3.向选择器中注册ACCEPT操作
        ssc.register(sele, SelectionKey.OP_ACCEPT);
        System.out.println("start...");
        //不停的循环选择，不停地处理

            //4.选择器进行选择操作
            //该方法是NIO中唯一一个阻塞的方法，没有就绪的就阻塞
        while (true) {
            sele.select();
            //5.获取就绪的键
            Set<SelectionKey> selectedKeys = sele.selectedKeys();
            if (selectedKeys.size() > 0) {
                Iterator<SelectionKey> it = selectedKeys.iterator();
                //6.遍历就绪的键
                while (it.hasNext()) {
                    SelectionKey key = it.next();
                    //7.判断当前就绪的键是什么类型的操作
                    if (key.isAcceptable()) {

                        ServerSocketChannel channel = (ServerSocketChannel) key.channel();
                        SocketChannel sc = null;
                        while (sc == null) {
                            sc = channel.accept();
                        }
                        System.out.println("连接成功：" + sc.getLocalAddress());
                        // 9.为读事件设置非阻塞，将sc注册到选择器中
                        sc.configureBlocking(false);
                        sc.register(sele, SelectionKey.OP_READ);

                    } /*else if (key.isWritable()) {
                        SocketChannel channel = (SocketChannel) key.channel();
                        ByteBuffer buf = ByteBuffer.wrap("hello nio".getBytes());
                        while (buf.hasRemaining()) {
                            channel.write(buf);
                        }

                    } */else if (key.isReadable()) {
                        //8.如果当前是READ操作，则去完成READ操作
                        SocketChannel sc = (SocketChannel) key.channel();
                        ByteBuffer buf = java.nio.ByteBuffer.allocate(1024);
//                        while (buf.hasRemaining()) {
                            sc.read(buf);
//                        }
                        String str = new String(buf.array());
                        System.out.println("接收到信息： " + str);
                        //注册写操作
                        sc.register(sele, SelectionKey.OP_WRITE);
                    } /*else {
                        throw new RuntimeException("ni ya! woburenshinia!");
                    }*/
                }
                //10.删除处理过的就绪的键
                it.remove();
            }
        }

    }
}
