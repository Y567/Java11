<%@ page import="java.util.Date" %>
<%@ page import="java.net.URLDecoder" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>hello</title>
</head>
<body>
<%
    //获取所有的cookie对象，并遍历是否有一个名字为lastTime的cookie
    Cookie[] cookies = request.getCookies();
    //标志对象，如果找到lastTime就为true，反之false
    boolean lastTime = false;
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
                response.addCookie(cookie);
                %>
欢迎回来，你上次访问的时间是：
<%=oldValue%>
<%
            }
        }
    }
    if(cookies == null || cookies.length == 0 || !lastTime){
        //第一次访问
        //重新设置cookie的value值发送回去
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 hh:mm:ss");
        Date date = new Date();
        Cookie cookie = new Cookie("lastTime", URLEncoder.encode(sdf.format(date),"utf-8"));
        cookie.setMaxAge(60*60*24*30);
        response.addCookie(cookie);
        %>
         欢迎您首次访问本网站
<%
    }
%>
</body>
</html>
