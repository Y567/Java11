package TCPClient;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * 文件上传的客户端
 */
public class Client2 {
    public static void main(String[] args) throws IOException {
        //创建本地的文件输入流对象绑定数据源
        FileInputStream fis = new FileInputStream("F:\\壁纸\\2.jpg");
        //创建客户端对象绑定服务器的套接字
        Socket socket = new Socket("127.0.0.1", 8888);
        //读取本地资源
        byte[] bytes = new byte[1024];
        int len = 0;
        while((len=fis.read(bytes)) != -1){
            //获取网络字节输出流将资源输出到服务器上
            OutputStream os = socket.getOutputStream();
            os.write(bytes,0,len);
        }

        /**
         * 上传完毕后要正常结束，否则服务器的read读不到结束标记-1，read会进入堵塞态
         * 于是在上传完毕后跟上一个shutdownOutput()正常结束输出流
         */

        socket.shutdownOutput();

        //获取网络字节输入流对象
        InputStream is = socket.getInputStream();
        while((len=is.read(bytes)) != -1){
            //输出到控制台
            System.out.println(new String(bytes,0,len));
        }

        //释放资源
        fis.close();
        socket.close();
    }
}
