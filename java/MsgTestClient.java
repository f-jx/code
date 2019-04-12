import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.net.*;

/*
 * 实现TCP客户端，接收到服务器
 * 和服务器实现数据交换
 * 实现TCP客户端程序的类 java.net.Socket
 * 
 * 构造方法：
 *         Socket(String host,int port) 传服务器IP和端口号
 *         注意：构造方法只要运行，就会和服务器进行连接，连接失败，抛出异常
 * 
 *         OutputStream getOutputStream() 返回套接字的输出流
 *             作用：将数据输出，输出到服务器
 * 
 *         InputStream getInputStream() 返回套接字的输入流
 *             作用：从服务端读取数据
 * 
 *         客户端服务器数据交换，必须使用套接字对象Socket中的获取的IO流，自己new流，不行
 */
public class MsgTestClient {
    public static void main(String[] args) {
        JFrame fr = new JFrame("Client");
        fr.setLayout(new FlowLayout());
        fr.setSize(500, 500);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setBackground(Color.blue);

        JTextField tf = new JTextField("Send messages", 15);
        tf.setEditable(true);
        fr.add(tf);

        JTextArea ta = new JTextArea("Receive Messages");
        JButton b = new JButton("Send");
        fr.add(b);
        fr.add(ta);
        fr.setVisible(true);
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e) {
                    // 创建Socket对象，连接服务器
                    Socket socket = new Socket("127.0.0.1", 8888);
                    // 通过客户端的套接字对象Socket方法，获取字节输出流，将数据写向服务器
                    OutputStream out = socket.getOutputStream();
                    out.write(tf.getText().getBytes());

                    // 读取服务器发回的数据，使用socket套接字对象中的字节输入流
                    InputStream in = socket.getInputStream();
                    byte[] data = new byte[1024];
                    int len = in.read(data);
                    String getMsg = new String(data, 0, len);
                    socket.close();
                    ta.setText(getMsg);
                }
            }
        });
    }
}