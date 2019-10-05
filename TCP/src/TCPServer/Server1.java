package TCPServer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *服务器端对象
 */
public class Server1 {
    public static void main(String[] args) throws IOException {
        //创建一个服务器端对象，并申请特定的端口号
        ServerSocket serverSocket = new ServerSocket(8888);
        //获取发送请求的客户端客户端对象
        Socket socket = serverSocket.accept();
        //获取网络字节输入流并接收数据
        InputStream inputStream = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int len = inputStream.read(bytes);
        System.out.println(new String(bytes,0,len));

        //获取网络字节输出流对象并返回数据给客户端
        OutputStream outputStream = socket.getOutputStream();

        outputStream.write("收到谢谢".getBytes());
        //释放资源
        socket.close();
        serverSocket.close();



    }
}
