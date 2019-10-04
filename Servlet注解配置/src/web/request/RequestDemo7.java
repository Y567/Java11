package web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 演示请求转发以及共享数据
 * 特点：
 * 1.浏览器地址栏不发生改变
 * 2.只能访问当前服务器内部资源
 * 3.转发是一次请求
 */
@WebServlet("/requestDemo7")
public class RequestDemo7 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //在转发之前存储数据
        req.setAttribute("name","mc.hz");
        //获取请求转发器对象,并调用forward方法进行转发
        req.getRequestDispatcher("/requestDemo8").forward(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
