package web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if(username.equals("superbaby") && password.equals("yy5201314")){
            //在转发之前，先保存共享数据
            req.setAttribute("name","superbaby");
            //请求转发到SuccessServlet
            req.getRequestDispatcher("/SuccessServlet").forward(req,resp);
        }else{
            //登录失败
            //请求跳转至失败servlet
            req.getRequestDispatcher("/FailServlet").forward(req,resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
