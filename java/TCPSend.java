import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class TCPSend {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入要发送的消息：");
        if (scan.hasNext()) {
            // 利用Scanner对象进行阻塞，接收输入的字符串
            String Msg = scan.next();
            // 创建Socket对象，连接服务器
            Socket socket = new Socket("127.0.0.1", 8088);
            // 通过Socket方法，将数据写向服务器
            OutputStream out = socket.getOutputStream();
            out.write(Msg.getBytes());

            // 读取服务器发回的数据
            InputStream in = socket.getInputStream();
            byte[] data = new byte[1024];
            int len = in.read(data);
            System.out.println(new String(data, 0, len));
            scan.close();
            socket.close();
        }
    }
}