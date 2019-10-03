package web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/RequestDemo1")
public class RequestDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求方式
        String method = req.getMethod();
        System.out.println(method);
        //获取虚拟目录
        String contextPath = req.getContextPath();
        System.out.println(contextPath);
        //获取访问路径
        String servletPath = req.getServletPath();
        System.out.println(servletPath);
        //获取get方式请求参数
        String queryString = req.getQueryString();
        System.out.println(queryString);
        //获取url
        String requestURI = req.getRequestURI();
        System.out.println(requestURI);
        StringBuffer requestURL = req.getRequestURL();
        System.out.println(requestURL);
        //获取协议及版本
        String protocol = req.getProtocol();
        System.out.println(protocol);
        //获取客户端ip
        String remoteAddr = req.getRemoteAddr();
        System.out.println(remoteAddr);
    }
}
