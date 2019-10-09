package web.response;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/PrintBytesToClient")
public class PrintBytesToClient extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取字节输出流
        resp.setContentType("text/html;charset=utf-8");
        ServletOutputStream sos = resp.getOutputStream();
        //字节输出流一般不用于输出汉字，用来下载文件图片什么的
        sos.write("你好".getBytes("utf-8"));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
