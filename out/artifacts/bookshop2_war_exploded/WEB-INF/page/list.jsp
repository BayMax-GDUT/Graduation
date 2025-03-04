<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/4/19
  Time: 11:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" import="java.util.*" isELIgnored="false"%>
<%@ page import="DAO.UserDAO" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--<jsp:include page="loginMessage.jsp">--%>
    <%--<jsp:param name="user" value="${param.userName}" />--%>
<%--</jsp:include>--%>
<%@include file="include_login_message.jsp"%>
<html>
<head>
    <meta name="viewport" content="width=device-width,initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
    <%--<link type="text/css" rel="stylesheet" href="mycss.css" />--%>
    <style type="text/css">
        body {
            background-color: rgb(49, 57, 89);
        }
        h3 {
            font-size: 36;
            color: #ffffff;
            text-align: center;
            margin: 0;
        }
        .deepblue {
            width: 300px;
            height: 50px;
            background-color: rgb(39, 38, 57);
            font-size: 18px;
            color: rgb(169, 169, 169);
            border-width: 0px;
        }
        .lightblue {
            width: 80px;
            height: 30px;
            background-color: rgb(92, 150, 217);
            font-size: 14px;
            color: #ffffff;
            border-width: 0px;
        }
        table {
            width: 90%;
            height: 10%;
            border-width: 0;
            text-align: center;
        }
        .headline {
            color: #516380;
        }  /* 表格标题文字颜色 */

        .firstline {
            background-color: #91a7bc;
        }  /* 表头行背景色 */

        .content {
            background-color: #dce1e3;
        }  /* 内容主题背景色 */
        .search-kuang {
            width: 220px;
            height: 30px;
            font-size: 14px;
            border-width: 0px;
        }
        .search-button {
            width: 60px;
            height: 30px;
            background-color: rgb(92, 150, 217);
            font-size: 14px;
            color: #ffffff;
            border-width: 0px;
        }
    </style>
</head>
<body>
<br><br>
<input align="right" type="button" onclick="checkLogin()" value="新增出售" class="lightblue">
<script language="JavaScript">
    function checkLogin() {
        var name = "<%=session.getAttribute("name")%>";
            if(name == "null") {
                alert("请先进行登录！");
                window.location ="/login";
            }
            if(name != "null")
            {
                window.location="/add_book";
            }

    }
</script>
<form action="search" align="center">
    <input type="text" name="name" value="" class="search-kuang" placeholder="图书名">
    &nbsp;&nbsp;&nbsp;&nbsp;
    <input type="submit" value="搜索" class="search-button">
</form>
<center>

<table  border='1' cellspacing='0'>
    <%--当前用户:<%=session.getAttribute("name")%>--%>
    <%--<%session.setAttribute("name", );%>--%>
    <caption class="headline">在售图书</caption>

    <tr class="firstline">
        <%--<td>id</td>--%>
        <td>名字</td>
        <td>出版社</td>
        <%--<td>image_path</td>--%>
        <td>价钱</td>
        <td>图书类型</td>
        <td>卖家</td>
        <td>操作</td>
    </tr>
    <c:forEach items="${books}" var = "book" varStatus="st">
        <tr class="content">
            <%--目前只判断是否买自己的书 是否登录功能将放到spring的面向切口编程中--%>
            <form action="/buy_book" onsubmit="return check(${book.getSeller_id()})" method="post">
        <%--<td>${book.getId()}</td>--%>
        <td>${book.getName()}</td>
        <td>${book.getPublisher()}</td>
        <%--<td>${book.getImage_path()}</td>--%>
            <td>${book.getPrice()}</td>
        <td>${book.getCategory()}</td>
        <td>${book.seller}</td>
            <td><input type="submit" value="购买" class="lightblue"></td>
                <input type="hidden" name="id" value="${book.getId()}">
            </form>
        </tr>
    </c:forEach>

</table><br><br>
</center>
</body>
</html>
<script>
    //检查是否用户买自己的书
    function check(seller_id) {
        var userName = "<%=(String)session.getAttribute("name")%>"
        var currentUserId = "<%=new UserDAO().getId((String) session.getAttribute("name"))%>";
        if("null" == userName)
        {
            alert("请先进行登录");
            return false;
        }
        else if(currentUserId == seller_id)
        {
            alert("不能购买自己的书");
            return false;
        }
        else
        {
            var select = confirm("确定购买这本书吗？");
            return select;
        }
    }
</script>


<%--<form action='list' method='post'>--%>
    <%--名字 ： <input type='text' name='name' value='${}'> <br>--%>
    <%--血量 ：<input type='text' name='hp' value='${"123"}'> <br>--%>
    <%--伤害： <input type='text' name='damage' value='${"456"}'> <br>--%>
    <%--&lt;%&ndash;<input type='hidden' name='id' value='${hero.id}'>&ndash;%&gt;--%>
    <%--<input type='submit' value='更新'>--%>
<%--</form>--%>