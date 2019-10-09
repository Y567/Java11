package web.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 重定向案例
 */
@WebServlet("/ResponesDirect1")
public class RequestDirect1 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("重定向1啦啦啦啦");
//        //设置状态码，让浏览器去重新找资源
//        resp.setStatus(302);
//        //设置响应头，告诉浏览器新资源的地址
//        resp.setHeader("location","/request/RequestDirect2");

        //动态获取虚拟目录
        String cp = req.getContextPath();
        System.out.println(cp);


        //因为重定向只有一个可变参数，所以就有了一个更简单的方法来实现
        resp.sendRedirect(cp+"/ResponesDirect2");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
