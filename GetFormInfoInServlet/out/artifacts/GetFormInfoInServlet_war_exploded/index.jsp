<%--
  Created by IntelliJ IDEA.
  User: Chenwz
  Date: 2019/4/18 0018
  Time: 16:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户注册</title>
</head>
<body>
<h1>请填写信息以完成注册</h1>
<hr/>
<form name="regForm" action="servlet/RegServlet" method="post">
    <table>
        <tr>
            <td>用户名：</td>
            <td>
                <label>
                    <input type="text" name="username" value="张三"/>
                </label>
            </td>
        </tr>
        <tr>
            <td>密码：</td>
            <td>
                <label>
                    <input type="password" name="userPwd" value="123456"/>
                </label>
            </td>
        </tr>
        <tr>
            <td>确认密码：</td>
            <td>
                <label>
                    <input type="password" name="userPwd_Confirm" value="123456"/>
                </label>
            </td>
        </tr>
        <tr>
            <td>性别：</td>
            <td>
                <label>
                    <input type="radio" name="gender" value="男"/>男
                    <input type="radio" name="gender" value="女"/>女
                </label>
            </td>
        </tr>
        <tr>
            <td>出生日期：</td>
            <td>
                <label>
                    <input type="date" name="birthday" value="1996-08-12"/>
                </label>
            </td>
        </tr>
        <tr>
            <td>电子邮箱：</td>
            <td>
                <label>
                    <input type="email" name="email" value="heythere@163.com"/>
                </label>
            </td>
        </tr>
        <tr>
            <td>爱好：</td>
            <td>
                <label>
                    <input type="checkbox" name="favorites" value="篮球"/>篮球
                    <input type="checkbox" name="favorites" value="音乐"/>音乐
                    <input type="checkbox" name="favorites" value="电影"/>电影
                    <input type="checkbox" name="favorites" value="游戏"/>游戏
                </label>
            </td>
        </tr>
        <tr>
            <td>自我介绍：</td>
            <td>
                <label>
                    <!--<input type="text" name="introduction" style="height: 200px"/>-->
                    <textarea rows="20" cols="25" style="height: 120px;" name="introduction">张三的自我介绍</textarea>
                </label>
            </td>
        </tr>
        <tr>
            <td></td>
            <td>
                <label>
                    <input type="checkbox" name="accAgreement" value="true"/>接受用户协议
                </label>
            </td>
        </tr>
        <tr>
            <td></td>
            <td>
                <input type="submit" value="注册" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <input type="reset" value="取消"/>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
