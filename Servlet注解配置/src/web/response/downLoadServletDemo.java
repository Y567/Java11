package web.response;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet("/downLoadServletDemo")
public class downLoadServletDemo extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取文件名，之后好进行文件查找
        String filename = req.getParameter("filename");


        //获取文件服务器路径（需要利用ServletContext对象）
        ServletContext servletContext = getServletContext();


        //设置响应头，首先得获得MiMe类型
        String mimeType = servletContext.getMimeType(filename);
        resp.setHeader("context-type",mimeType);

        //设置以附件形式打开(attachment)
        resp.setHeader("content-disposition","attachment;filename="+filename);


        String realPath = servletContext.getRealPath("/movies/"+filename);
        //利用文件输入流将文件加载入内存
        FileInputStream fis = new FileInputStream(realPath);
        ServletOutputStream sos = resp.getOutputStream();
        byte[] bytes = new byte[1024 * 8];
        int len = 0;
        while((len = fis.read(bytes))!=-1){
            //利用respones输出流将其输出到客户端
            sos.write(bytes,0,len);
        }
        fis.close();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
