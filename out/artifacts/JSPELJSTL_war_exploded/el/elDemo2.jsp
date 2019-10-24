<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/10/23
  Time: 21:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>el表达式获取值</title>
</head>
<body>
<%
    request.setAttribute("阿狗","stupid");
    session.setAttribute("sorry","baby");
%>
${requestScope.阿狗}
<%--省略域名称，按域的大小从小到大查找（前提，键值唯一）--%>
${阿狗}
${sessionScope.sorry}
${sorry}
</body>
</html>
