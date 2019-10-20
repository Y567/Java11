package web.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
    "欢迎" 案例
 */
@WebServlet("/cookieTest")
public class CookieTest extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取所有的cookie对象，并遍历是否有一个名字为lastTime的cookie
        Cookie[] cookies = req.getCookies();
        //标志对象，如果找到lastTime就为true，反之false
        boolean lastTime = false;
        resp.setContentType("text/html;charset=utf-8");
        if(cookies != null && cookies.length > 0){
            for (Cookie cookie : cookies) {
                String name = cookie.getName();
                if("lastTime".equals(name)){
                    //找到了，不是第一次访问
                    lastTime = true;
                    //获取该cookie的value值即时间并响应
                    Date date = new Date();
                    String oldValue = cookie.getValue();
                    //取出来需要解码
                    oldValue = URLDecoder.decode(oldValue,"utf-8");
                    //重新设置cookie的value值发送回去
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 hh:mm:ss");
                    //Tomcat8虽然对中文数据有了支持，但是对特殊字符还是需要进行URL编码
                    cookie.setValue(URLEncoder.encode(sdf.format(date),"utf-8"));
                    cookie.setMaxAge(60*60*24*30);
                    resp.addCookie(cookie);
                    resp.getWriter().write("欢迎回来，你上次访问的时间是："+oldValue);
                }
            }
        }
        if(cookies == null || lastTime == false){
            //第一次访问
            //重新设置cookie的value值发送回去
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 hh:mm:ss");
            Date date = new Date();
            Cookie cookie = new Cookie("lastTime", URLEncoder.encode(sdf.format(date),"utf-8"));
            cookie.setMaxAge(60*60*24*30);
            resp.addCookie(cookie);
            resp.getWriter().write("欢迎您首次访问本网站");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
