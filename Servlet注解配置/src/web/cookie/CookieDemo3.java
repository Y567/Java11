package web.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Cookie setMaxAge(int seconds)存活期
 * setMaxAge(30)  整数表示将cookie数据持久化到硬盘里。30秒后自动删除
 * setMaxAge(0)  直接删除
 * setMaxAge(-1)  默认，在浏览器关闭后会删除
 *
 */
@WebServlet("/cookieDemo3")
public class CookieDemo3 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //创建会话，绑定数据
        Cookie cookie = new Cookie("ag","niubi");
/*        //持久化到硬盘300秒
        cookie.setMaxAge(300);*/
        //发送数据
        resp.addCookie(cookie);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
