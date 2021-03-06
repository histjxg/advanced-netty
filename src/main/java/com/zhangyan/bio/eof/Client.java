package com.zhangyan.bio.eof;

import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: Messi
 * @Date: 2020/05/18/7:44 下午
 * @Description:
 */
public class Client {
    private static int PORT = 8080;
    private static String HOST = "127.0.0.1";

    public static void main(String[] args) throws Exception {
        Socket socket = new Socket();
//        socket.setTcpNoDelay(true);

        SocketAddress address = new InetSocketAddress(HOST, PORT);
        socket.connect(address);

        OutputStream output = socket.getOutputStream();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            sb.append("a");
        }
        sb.append('\n');
        byte[] request = sb.toString().getBytes("utf-8");
        output.write(request);

        // 发送第二个请求
        sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            sb.append("b");
        }
        sb.append('\n');
        request = sb.toString().getBytes("utf-8");
        output.write(request);

        long start = System.currentTimeMillis();
        socket.close();
        long end = System.currentTimeMillis();
        System.out.println("close time cost: " + (end - start));
    }
}
