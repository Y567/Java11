<%@ page import="web.User" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/10/23
  Time: 21:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>el表达式获取对象值</title>
</head>
<body>
<%
    User user = new User("阿狗", 20, new Date());
    request.setAttribute("user",user);
    ArrayList<String> list = new ArrayList<>();
    list.add("阿狗");
    list.add("阿🌤");
    list.add("阿崇");
    request.setAttribute("list",list);

    HashMap<String, String> map = new HashMap<>();
    map.put("一号床","会长");
    map.put("三号床","阿狗");
    map.put("四号床","王柏川");
    request.setAttribute("map",map);
%>
<h3>el表达式获取对象的属性</h3>
${requestScope.user.name}<br/>
${user.name}<br/>
${user.age}<br/>
${user.birthday}<br/>
${"格式化后的生日"}
${user.birStr}<br/>
${requestScope.user.birStr}
<h3>el表达式获取List集合</h3>
${list[2]}<br/>
<h3>el表达式获取map集合</h3>
${requestScope.map.一号床}<br/>
<h4>通过第二种方式获取</h4>
${requestScope.map["三号床"]}
</body>
</html>
