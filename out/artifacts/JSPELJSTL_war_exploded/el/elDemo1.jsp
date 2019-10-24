<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/10/23
  Time: 13:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>elDemo1</title>
</head>
<body>
${"王柏川牛逼"}
<%
    String str = "";
    request.setAttribute("str",str);
%>
<h3>逻辑运算符</h3>
${empty str}
</body>
</html>
