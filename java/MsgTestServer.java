import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.net.*;

/*
 * 实现TCP服务器程序
 * 表示服务器程序的类 java.net.ServerSocket
 * 构造方法：
 *         ServerSocket(int port) 传递端口号
 * 
 * 很重要的事情：必须要获得客户端的套接字对象Socket
 *     Socket accept()
 */
public class MsgTestServer {
    public static void main(String[] args) throws IOException {
        JFrame fr = new JFrame("Server");
        fr.setSize(500, 500);
        fr.setBackground(Color.blue);
        fr.setLayout(new FlowLayout());
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextArea ta = new JTextArea("Receive Massages");

        ServerSocket server = new ServerSocket(8088);
        // 调用服务器套接字对象中的方法accept()获取客户端套接字对象
        Socket socket = server.accept();
        // 通过客户端套接字对象，socket获取字节输入流,读取的是客户端发送来的数据
        InputStream is = socket.getInputStream();
        InetAddress ia = socket.getInetAddress();
        int p = socket.getPort();
        byte[] data = new byte[1024];
        int len = is.read(data);
        String getMsg = new String(data, 0, len);
        ta.setText(getMsg + "\n客户端地址：" + ia + "\n端口号：" + p);

        // 服务器向客户端回数据，字节输出流，通过客户端套接字对象获取字节输出流
        OutputStream out = socket.getOutputStream();
        out.write("收到，谢谢".getBytes());
        fr.add(ta);
        fr.setVisible(true);

        socket.close();
        server.close();
    }
}