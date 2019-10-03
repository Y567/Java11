package web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

/**
 * 演示利用请求参数通用方式获取请求体数据
 */
@WebServlet("/requestDemo5")
public class RequestDemo5 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //(1)getParameter方法
/*        String username = req.getParameter("username");
        System.out.println(username);
        //(2)getParameterValues()方法用于复选框的获取值
        String[] hobbies = req.getParameterValues("hobby");
        System.out.println(Arrays.toString(hobbies));*/


        System.out.println("---------------------");
        //(3)getParameterNames()方法，获取所有请求的参数名称
        Enumeration<String> parameterNames = req.getParameterNames();
        while(parameterNames.hasMoreElements()){
            String s = parameterNames.nextElement();
            System.out.println(s);
        }

        System.out.println("---------------------");
        //(4)getParameterMap()获取所有参数的Map集合
        Map<String, String[]> parameterMap = req.getParameterMap();
        Set<String> key = parameterMap.keySet();
        for (String s:key){
            System.out.println(s+":"+ Arrays.toString(parameterMap.get(s)));
        }
    }
}
