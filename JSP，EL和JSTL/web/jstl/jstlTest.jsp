<%@ page import="web.User" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/10/24
  Time: 17:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>案例</title>
</head>
<body>
<%
    List<User> user = new ArrayList<>();
    user.add(new User("张三",23,new Date()));
    user.add(new User("阿狗",25,new Date()));
    user.add(new User("小博哥",21,new Date()));
    user.add(new User("会长",22,new Date()));
    request.setAttribute("user",user);
%>
<table border="1" align="center">
    <th>编号</th>
    <th>姓名</th>
    <th>年龄</th>
    <th>生日</th>
    <c:forEach items="${user}" var="user" varStatus="s">
        <c:if test="${s.count % 2 == 0}">
            <tr bgcolor="#98fb98">
                <td>${s.count}</td>
                <td>${user.name}</td>
                <td>${user.age}</td>
                <td>${user.birStr}</td>
            </tr>
        </c:if>
        <c:if test="${s.count % 2 != 0}">
            <tr bgcolor="#ff7f50">
                <td>${s.count}</td>
                <td>${user.name}</td>
                <td>${user.age}</td>
                <td>${user.birStr}</td>
            </tr>
        </c:if>

    </c:forEach>

</table>
</body>
</html>
