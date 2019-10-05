package TCPClient;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client1 {
    public static void main(String[] args) throws IOException {
        //创建socket客户端对象
        Socket socket = new Socket("127.0.0.1", 8888);
        //获取网络字节输出流
        OutputStream outputStream = socket.getOutputStream();
        //向服务器端发送消息
        outputStream.write("你好服务器".getBytes());

        //接受服务器端发送的消息，首先得获取网络字节输入流对象
        InputStream inputStream = socket.getInputStream();
        //读取数据
        byte[] bytes = new byte[1024];
        int len = inputStream.read(bytes);
        //输出数据
        System.out.println(new String(bytes,0,len));
        //最后在释放资源
        socket.close();
    }
}
