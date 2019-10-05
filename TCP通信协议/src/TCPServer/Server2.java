package TCPServer;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 文件上传的服务器端
 */
public class Server2 {
    public static void main(String[] args) throws IOException {
        //创建服务器对象,并要特定的端口号
        ServerSocket serverSocket = new ServerSocket(8888);
        //获取发送请求的客户端对象
        Socket socket = serverSocket.accept();
        //判断本地文件夹是否存在
        File file = new File("F:\\upload");
        if(!file.exists()){
            file.mkdir();
        }
        //获取网络字节输入流读取客户端上传的数据
        InputStream is = socket.getInputStream();
        //获取本地字节输出流，向硬盘中写入文件
        FileOutputStream fos = new FileOutputStream(file+"\\2.jpg");
        byte[] bytes = new byte[1024];
        int len = 0;
        while((len = is.read(bytes)) != -1){
            fos.write(bytes,0,len);
        }

        //保存成功后，向客户端发送上传成功
        //获取网络字节输出流
        OutputStream os = socket.getOutputStream();
        os.write("上传成功".getBytes());
        //释放资源
        fos.close();
        serverSocket.close();
        socket.close();
    }
}
