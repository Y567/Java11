package web.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 重定向案例
 */
@WebServlet("/ResponesDirect2")
public class RequestDirect2 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("重定向2啦啦啦啦");
        //解决中文乱码
        resp.setContentType("text/html;charset=utf-8"); //在获取流对象之前声明，否则没用
        PrintWriter writer = resp.getWriter();
        //输出字符数据
        writer.write("你好啊，response");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
