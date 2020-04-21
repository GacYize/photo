package test.demo.io;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/**
 * @author ghj
 * @Description
 * @date 2020/3/26 10:51
 */
public class NioClientDemo {

    public static void main(String[] args) throws IOException {
        // 0.准备选择器
        Selector sele = Selector.open();
        // 1.创建sc通道对象
        SocketChannel sc = SocketChannel.open();
        // 2.设置非阻塞模式
        sc.configureBlocking(false);
        // 3.地址和端口
        sc.connect(new InetSocketAddress("127.0.0.1", 8080));
        // 4.注册事件
        sc.register(sele, SelectionKey.OP_CONNECT);
        // 选择和处理
        while (true) {
            // 执行选择的操作，惟一阻塞方法
            sele.select();
            Set<java.nio.channels.SelectionKey> keys = sele.selectedKeys();
            if (keys.size() > 0) {
                Iterator<SelectionKey> it = keys.iterator();
                while (it.hasNext()) {
                    SelectionKey key = it.next();
                    if (key.isAcceptable()) {

                    } else if (key.isConnectable()) {
                        SocketChannel channel = (SocketChannel) key.channel();
                        while (!channel.isConnected()) {
                            channel.finishConnect();
                        }
                        // 注册写事件到选择器
                        channel.register(sele, SelectionKey.OP_WRITE);

                    } else if (key.isWritable()) {
                        // 获取write的通道
                        SocketChannel channel = (SocketChannel) key.channel();
                        Scanner scanner = new Scanner(System.in);
                        System.out.println("请输入");
                        ByteBuffer buf = ByteBuffer.wrap(scanner.nextLine().getBytes());
                        while (buf.hasRemaining()) {
                            channel.write(buf);
                        }
                        // 注册一个读操作
                        channel.register(sele, SelectionKey.OP_READ);

                    } else if (key.isReadable()) {
                        SocketChannel channel = (SocketChannel) key.channel();
                        ByteBuffer buf = java.nio.ByteBuffer.allocate(9);
                        while (channel.read(buf) != -1) {
                            channel.read(buf);
//                            System.out.println("sjdfs");
                        }
                        String str = new String(buf.array());
                        System.out.println("server： " + str);

                        // 取消write操作的注册，防止多次write
                        key.cancel();
                    } else {
                        throw new RuntimeException("ni ya! woburenshinia!");
                    }
                }
                // 从就绪的键集中删除已经处理的键
                it.remove();
            }

        }
    }
}
