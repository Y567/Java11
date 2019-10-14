package web.servletcontext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ServletContextDemo4")
public class ServletContextDemo4 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取ServletContext对象
        ServletContext context = getServletContext();
        //2.web目录下访问资源
        String a = context.getRealPath("/a.txt");
        System.out.println(a);
        //3.WEB-INF目录下访问资源
        String c = context.getRealPath("/WEB-INF/c.txt");
        System.out.println(c);
        //4.src目录下的访问资源
        String b = context.getRealPath("/WEB-INF/classes/b.txt");
        System.out.println(b);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
