package web;

import javax.servlet.*;
import java.io.IOException;

/**
 * servlet是一个接口，实现这个接口的Java类运行在服务器端
 */
public class HelloServlet implements Servlet {
    //servlet对象可以在服务器启动时创建，也可以在第一次访问是被创建
    //在服务器启动时创建需要进行配置
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init（）被执行了");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    //提供服务的一个抽下那个方法
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("service（）被执行了");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("我不想死啊呜呜呜呜");
    }
}
