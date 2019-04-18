<%--
  Created by IntelliJ IDEA.
  User: Chenwz
  Date: 2019/4/18 0018
  Time: 14:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ServletDemo</title>
</head>
<body>
<h1>第一个Servlet例子</h1>
<hr/>
<a href="servlet/HelloServlett">Get方式请求HelloServlet</a><br/>
<form action="servlet/HelloServlett" method="post">
    <input type="submit" value="Post方式请求HelloServlet"/>
</form>
</body>
</html>
