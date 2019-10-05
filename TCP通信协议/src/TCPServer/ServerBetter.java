package TCPServer;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

/**
 * 文件上传的服务器端(优化)
 * 死循环+多线程实现服务器一直监听和多客户端同时上传的问题
 */
public class ServerBetter {
    public static void main(String[] args) throws IOException {
        //创建服务器对象,并要特定的端口号
        ServerSocket serverSocket = new ServerSocket(8888);
        while(true){
            //获取发送请求的客户端对象
            Socket socket = serverSocket.accept();
            new Thread(new Runnable(){
                @Override
                public void run() {
                    try{
                        //判断本地文件夹是否存在
                        File file = new File("F:\\upload");
                        if(!file.exists()){
                            file.mkdir();
                        }
                        //获取网络字节输入流读取客户端上传的数据
                        InputStream is = socket.getInputStream();

                        //随机命名
                        String fileName = System.currentTimeMillis()+ new Random().nextInt(99999)+".jpg";
                        //获取本地字节输出流，向硬盘中写入文件
                        FileOutputStream fos = new FileOutputStream(file+"\\"+fileName);
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
                        socket.close();
                    }catch (IOException e){
                        System.out.println(e);
                    }
                }
            }).start();
            //服务器不需要关闭了因为一直处于运行状态
            //serverSocket.close();
        }
    }
}
