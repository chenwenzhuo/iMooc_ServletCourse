<%@ page import="java.util.ArrayList" %>
<%@ page import="entity.Items" %>
<%@ page import="dao.ItemsDAO" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: Chenwz
  Date: 2019/4/23 0023
  Time: 16:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=utf-8" language="java" %>
<html>
<head>
    <title>浏览商品</title>
    <style type="text/css">
        div {
            float: left;
            margin: 10px;
        }

        div dd {
            margin: 0;
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
            border-width: 1px;
        }

        img {
            border-width: 1px;
            width: 120px;
            height: 90px;
        }
    </style>
</head>
<body>
<h1>所有商品如下所示</h1>
<hr/>

<div>
    <table>
        <tr>
            <td>
                <!-- 商品循环开始 -->
                <%
                    ItemsDAO itemsDao = new ItemsDAO();
                    List<Items> allItems = itemsDao.getAllItems();

                    if (allItems != null && allItems.size() > 0) {
                        for (Items item : allItems) {
                %>
                <div>
                    <dl>
                        <dt>
                            <a href="details.jsp?id=<%=item.getId()%>"><img src="images/<%=item.getPicture()%>"
                                                                            alt="<%=item.getName()%>"/></a>
                        </dt>
                        <dd class="dd_name"><%=item.getName() %>
                        </dd>
                        <dd class="dd_city">产地:<%=item.getCity() %>&nbsp;&nbsp;价格:￥ <%=item.getPrice() %>
                        </dd>
                    </dl>
                </div>
                <!-- 商品循环结束 -->
                <%
                        }
                    }
                %>
            </td>
        </tr>
    </table>
</div>
</body>
</html>
