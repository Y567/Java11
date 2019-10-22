<%--
  指令，
--%>
<%@include file="top.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" errorPage="error.jsp" language="java" %>
<html>
  <head>
    <title>首页</title>
  </head>
  <body>
  欢迎光临！

  <%--内置对象可以直接使用--%>
  <%--pageContext对象可以页面内共享数据--%>
  <%
     pageContext.setAttribute("阿狗","牙医系");
  %>

  <%
    Object dog = pageContext.getAttribute("阿狗");
  %>
  <%=dog%>
  </body>
</html>
