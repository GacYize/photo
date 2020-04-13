package test.dome;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author ghj
 * @Description
 * @date 2020/3/6 14:33
 */
public class LocalJedis {
    private Socket socket;

    private InputStream read;

    private OutputStream write;

    public LocalJedis(String ip, Integer port) throws IOException {
        this.socket = new Socket(ip, port);
        this.read = socket.getInputStream();
        this.write = socket.getOutputStream();
    }

    public String set(String key, String value) throws IOException {
        StringBuffer sb = new StringBuffer();
        sb.append("*3").append("\r\n");
        sb.append("$3").append("\r\n");
        sb.append("SET").append("\r\n");
        sb.append("$").append(key.getBytes().length).append("\r\n");
        sb.append(key).append("\r\n");
        sb.append("$").append(value.getBytes().length).append("\r\n");
        sb.append(value).append("\r\n");
        write.write(sb.toString().getBytes());
        byte[] arr = new byte[1024];
        read.read(arr);
        return new String(arr);
    }

    public String get(String key) throws IOException {
        StringBuffer sb = new StringBuffer();
        sb.append("*2").append("\r\n");
        sb.append("$3").append("\r\n");
        sb.append("GET").append("\r\n");
        sb.append("$").append(key.getBytes().length).append("\r\n");
        sb.append(key).append("\r\n");
        write.write(sb.toString().getBytes());
        byte[] arr = new byte[1024];
        read.read(arr);
        return new String(arr);
    }

}
