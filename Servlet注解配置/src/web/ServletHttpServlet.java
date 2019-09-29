package web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
//第一种方式
//@WebServlet("/demo3")
//第二种方式
@WebServlet("/y/y")
//第三种方式
//@WebServlet("*.love")
public class ServletHttpServlet extends HttpServlet {
    //该类是Servlet的子类，已经实现了那5个抽象方法且在services()方法中进行了逻辑判断，获取请求数据根据
    //不同的请求方式调用不同的逻辑方法（1.doGet()  2.doPost()）,所以我们需要覆写这两个方法

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("来自网页的get方式");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("来自网页的post请求");
    }
}
