package web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/SuccessServlet")
public class SuccessServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //说明转发成功，需要在界面上欢迎来到本界面(加上用户名)
        //获取共享数据
        Object name = req.getAttribute("name");
        //需要改变编码
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().write("登录成功，"+name+"欢迎来到本界面");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
