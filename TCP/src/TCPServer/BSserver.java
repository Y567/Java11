package TCPServer;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 模拟B/S服务器，给浏览器响应回去一个网页
 */
public class BSserver {
    public static void main(String[] args) throws IOException {
        //创建服务器对象
        ServerSocket serverSocket = new ServerSocket(8888);
        while(true){
            //获取客户端对象(浏览器对象)
            Socket socket = serverSocket.accept();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try{
                        //创建网络字节输入流读取请求数据
                        InputStream is = socket.getInputStream();
/*        //读取数据
        byte[] bytes = new byte[1024];
        int len = 0;
        while((len = is.read(bytes)) != -1){
            System.out.println(new String(bytes,0,len));
        }*/

                        //将网络字节流转换为字符缓冲流（方便进行html文件的读取与响应）
                        BufferedReader br = new BufferedReader(new InputStreamReader(is));
                        //读取请求网页的路径 /TCP通信协议/web/index.html,读取一行就可以，因为请求头已经包含了路径
                        String line = br.readLine();
                        System.out.println(line);
                        //将路径利用字符串分割分割出来
                        String[] arr = line.split(" ");
                        //去掉第一个'/'
                        String path = arr[1].substring(1);

                        /*            String path = "TCP/web/index.html";*/
                        //绑定读取源数据,找到了index.html所在位置
                        FileInputStream fis = new FileInputStream(path);
                        //获取网络字节输出流，将数据响应给客户端
                        OutputStream os = socket.getOutputStream();

                        //写响应头
                        os.write("HTTP/1.1 200 OK\r\n".getBytes());
                        os.write("Content-Type:text/html\r\n".getBytes());
                        os.write("\r\n".getBytes());

                        //一边读本地html文件，一边响应
                        byte[] bytes = new byte[1024];
                        int len = 0;
                        while((len = fis.read(bytes))!=-1){
                            //响应html文件
                            os.write(bytes,0,len);
                        }
                        //释放资源
                        fis.close();
                        socket.close();
                    }catch(IOException e){
                        System.out.println(e);
                    }
                }
            }).start();

        }
    }
}
