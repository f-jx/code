import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPReceive {
    public static void main(String[] args) throws IOException {
        System.out.println("等待客户端消息...");
        ServerSocket server = new ServerSocket(8088);
        // 调用accept()方法进行阻塞，获取客户端套接字对象
        Socket socket = server.accept();
        // 读取的是客户端发送的数据
        InputStream in = socket.getInputStream();
        byte[] data = new byte[1024];
        int len = in.read(data);
        String getMsg = new String(data, 0, len);
        System.out.println("收到客户端消息：（客户端地址：" + socket.getInetAddress() + "\t端口号：" + socket.getPort() + "）\n" + getMsg);

        // 向客户端回复数据
        OutputStream out = socket.getOutputStream();
        out.write("来自服务器的回复：\n收到，谢谢!".getBytes());

        socket.close();
        server.close();
    }
}