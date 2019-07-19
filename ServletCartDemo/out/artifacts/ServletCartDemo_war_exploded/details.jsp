<%@ page import="entity.Items" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="dao.ItemsDAO" %><%--
  Created by IntelliJ IDEA.
  User: Chenwz
  Date: 2019/4/23 0023
  Time: 16:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=utf-8" language="java" %>
<html>
<head>
    <title>商品详情</title>
    <style type="text/css">
        div {
            float: left;
            margin: 5px 30px;
        }

        div dd {
            margin: 0px;
            font-size: 10pt;
        }

        div dd.dd_name {
            color: blue;
        }

        div dd.dd_city {
            color: #000;
        }

        table {
            width: 750px;
            height: 60px;
            border-width: 0;
        }
    </style>
</head>
<body>
<h1>商品详情</h1>
<hr>

<div style="text-align: center;">
    <table>
        <tr>
            <!-- 商品详情 -->
            <%
                ItemsDAO itemDao = new ItemsDAO();
                Items item = itemDao.getItemDetailsById(Integer.parseInt(request.getParameter("id")));
                if (item != null) {
            %>
            <td width="70%" valign="top">
                <table>
                    <tr>
                        <td rowspan="4"><img src="images/<%=item.getPicture()%>" width="200" height="160"
                                             alt="<%=item.getName()%>"/></td>
                    </tr>
                    <tr>
                        <td><B><%=item.getName() %>
                        </B></td>
                    </tr>
                    <tr>
                        <td>产地：<%=item.getCity()%>
                        </td>
                    </tr>
                    <tr>
                        <td>价格：<%=item.getPrice() %>￥</td>
                    </tr>
                </table>
            </td>
            <%
                }
            %>
            <%
                String list = "";
                //从客户端获得Cookies集合
                Cookie[] cookies = request.getCookies();
                //遍历这个Cookies集合
                if (cookies != null && cookies.length > 0) {
                    for (Cookie c : cookies) {
                        if (c.getName().equals("ListViewCookie")) {
                            list = c.getValue();
                        }
                    }
                }
                list += request.getParameter("id");

                //如果浏览记录超过100条，清零.
                if (list.length() >= 100) {
                    list = "";
                }
                Cookie cookie = new Cookie("ListViewCookie", list);
                response.addCookie(cookie);
            %>

            <!-- 浏览过的商品 -->
            <td width="30%" bgcolor="#EEE" align="center">
                <br>
                <b>您浏览过的商品</b><br>
                <!-- 循环开始 -->
                <%
                    ArrayList<Items> itemList = itemDao.getViewList(list);
                    if (itemList != null && itemList.size() > 0) {
                        System.out.println("itemList.size=" + itemList.size());
                        for (Items i : itemList) {

                %>
                <div>
                    <dl>
                        <dt>
                            <a href="details.jsp?id=<%=i.getId()%>"><img src="images/<%=i.getPicture() %>" width="120"
                                                                         height="90" border="1" alt="<%=i.getName()%>"/></a>
                        </dt>
                        <dd class="dd_name"><%=i.getName() %>
                        </dd>
                        <dd class="dd_city">产地:<%=i.getCity() %>&nbsp;&nbsp;价格:<%=i.getPrice() %> ￥</dd>
                    </dl>
                </div>
                <%
                        }
                    }
                %>
                <!-- 循环结束 -->
            </td>
        </tr>
    </table>
</div>
</body>
</html>
