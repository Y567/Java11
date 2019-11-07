<%@ page import="java.util.ArrayList" %>
c:forEach=""C:choose=""<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/10/24
  Time: 17:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>jstl基本使用</title>
</head>
<body>
<h3>if标签</h3>
<%
    String s = "";
    request.setAttribute("str",s);
%>
<c:if test="${empty str}">
    if条件成立
</c:if>
<h3>choose标签</h3>
<%
    request.setAttribute("week",3);
%>
<c:choose>
<c:when test="${week == 3}">
周三
</c:when>
<c:when test="${week == 4}">
周四
</c:when>
<c:otherwise>
周其他
</c:otherwise>
</c:choose>
<h3>forEach标签</h3>
<%
    ArrayList<String> list = new ArrayList<>();
    list.add("aaa");
    list.add("ccc");
    list.add("ddd");
    request.setAttribute("list",list);
%>
<c:forEach begin="1" end="10" var="i" step="1" varStatus="s">
    ${i}
</c:forEach>
<c:forEach items="${list}" var="str" varStatus="s">
    ${str}
</c:forEach>
</body>
</html>
