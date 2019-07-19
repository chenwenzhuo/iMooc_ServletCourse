<%--
  Created by IntelliJ IDEA.
  User: Chenwz
  Date: 2019/4/22 0022
  Time: 18:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页</title>
</head>
<body>
<h1>Servlet路径跳转</h1>
<hr/>

<h3>JSP跳转到Servlet</h3><br/>
<a href="servlet/HelloServlet">相对路径访问HelloServlet</a><br/>
<!--绝对路径访问HelloServlet，使用内置变量path实现-->
<!--通过path得到的是项目的根目录-->
<%
    String path = request.getContextPath();
%>
<a href="<%=path%>/servlet/HelloServlet">绝对路径访问HelloServlet</a><br/><br/>

<h3>Servlet跳转到JSP</h3><br/>
<a href="servlet/TransferServlet">访问TransferServlet，跳转到destination.jsp</a>
</body>
</html>
