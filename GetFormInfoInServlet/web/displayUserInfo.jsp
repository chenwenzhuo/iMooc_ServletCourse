<%@ page import="java.text.SimpleDateFormat" %><%--
  Created by IntelliJ IDEA.
  User: Chenwz
  Date: 2019/4/18 0018
  Time: 17:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户信息</title>
    <style>
        table, td {
            border: 1px solid black;
            border-collapse: collapse;

            text-align: center;
            margin: auto;
            width: 500px;
        }
    </style>
</head>
<body>
<h1>新用户信息</h1>
<hr/>
<div style="text-align: center;">
    <jsp:useBean id="regUser" class="entity.User" scope="session"/>
    <table>
        <tr>
            <td class="title" style="background-color: gainsboro">用户名</td>
            <td class="contentContainer" style="background-color: cyan">
                <jsp:getProperty name="regUser" property="username"/>
            </td>
        </tr>
        <tr>
            <td class="title" style="background-color: gainsboro">密码</td>
            <td class="contentContainer" style="background-color: cyan">
                <jsp:getProperty name="regUser" property="userPwd"/>
            </td>
        </tr>
        <tr>
            <td class="title" style="background-color: gainsboro">性别</td>
            <td class="contentContainer" style="background-color: cyan">
                <jsp:getProperty name="regUser" property="gender"/>
            </td>
        </tr>
        <tr>
            <td class="title" style="background-color: gainsboro">生日</td>
            <td class="contentContainer" style="background-color: cyan">
                <%
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
                    String birthdayStr = sdf.format(regUser.getBirthday());
                %>
                <%=birthdayStr%>
            </td>
        </tr>
        <tr>
            <td class="title" style="background-color: gainsboro">电子邮箱</td>
            <td class="contentContainer" style="background-color: cyan">
                <jsp:getProperty name="regUser" property="email"/>
            </td>
        </tr>
        <tr>
            <td class="title" style="background-color: gainsboro">爱好</td>
            <td class="contentContainer" style="background-color: cyan">
                <%
                    String[] favorites = regUser.getFavorites();
                    for (String favorite : favorites) {
                %>
                <%=favorite%>&nbsp;&nbsp;
                <%
                    }
                %>
            </td>
        </tr>
        <tr>
            <td class="title" style="background-color: gainsboro">自我介绍</td>
            <td class="contentContainer" style="background-color: cyan">
                <jsp:getProperty name="regUser" property="introduction"/>
            </td>
        </tr>
        <tr>
            <td class="title" style="background-color: gainsboro">接受用户协议</td>
            <td class="contentContainer" style="background-color: cyan">
                <%
                    if (regUser.isAccAgreement()) {
                %>
                <%="接受"%>
                <%
                } else {
                %>
                <%="不接受"%>
                <%
                    }
                %>
            </td>
        </tr>
    </table>
</div>
</body>
</html>
