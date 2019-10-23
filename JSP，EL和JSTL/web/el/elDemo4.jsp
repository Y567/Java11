<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/10/23
  Time: 22:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>el隐式对象</title>
</head>
<body>
<h3>动态获取虚拟目录（4个域对象也是隐式对象，这里示例了request）</h3>
${pageContext.request.contextPath}
</body>
</html>
