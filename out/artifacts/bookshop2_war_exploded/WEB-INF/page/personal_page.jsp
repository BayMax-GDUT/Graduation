<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="bean.User" %>
<%@ page import="DAO.UserDAO" %>
<%@ page import="DAO.CategoryDAO" %>
<%@ page import="DAO.BookDAO" %>
<%@ page import="sun.security.util.Password" %>
<script src="http://how2j.cn/study/jquery.min.js"></script>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/4/28
  Time: 14:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" pageEncoding="UTF-8" %>
<%@include file="include_login_message.jsp"%>
<html>
<head>
    <meta content="text/html;charset=UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
    <title>个人中心</title>
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
<% User user = new UserDAO().getCurrentUser((String) session.getAttribute("name"));%>
<center>
    <form action="/update_user" method="post" onsubmit="return changeInformation()">
<table border='1' cellspacing='0'>
    <captain class="headline">个人信息</captain>
    <tr class="firstline">
        <td><center>属性</center></td>
        <td><center>值</center></td>
    </tr>


    <tr class="content">
        <td>姓名</td>
        <td><%=user.getName()%></td>
    </tr>
    <tr class="content">
        <td>学校</td>
        <td><%=user.getSchool()%></td>
    </tr>
    <tr class="content">
        <td>学号</td>
        <td><%=user.getNumber()%></td>
    </tr>
    <tr class="content">
        <td>密码</td>
        <td><input type="password" value="<%=user.getPassword()%>" name="password"></td>
    </tr>
    <tr class="content">
        <td>地址</td>
        <td><input type="text" value="<%=user.getAddress()%>" name="address"></td>
    </tr>
    <tr class="content">
        <td>联系方式</td>
        <td><input type="text" value="<%=user.getPhone_number()%>" name="phone_number"></td>
    </tr>
</table>
    <input type="submit" align="center" onsubmit="return changeInformation()" value="保存更改" class="lightblue">
    </form>
    <br><br>

    <%--插入一个此账号在售图书列表--%>
    <table border='1' cellspacing='0'>
    <captain class="headline">在售图书</captain>
    <tr class="firstline">
        <%--<td>id</td>--%>
        <td>名字</td>
        <td>出版社</td>
        <%--<td>image_path</td>--%>
        <td>价钱</td>
        <td>图书类型</td>
        <td>操作</td>
        <%--<td>seller</td>--%>
    </tr>
    <c:forEach items="${books}" var = "book" varStatus="st">
        <tr class="content">
            <form action="/unsell_book" onsubmit="return deleteBook()" method="post">
            <%--<td>${book.getId()}</td>--%>
            <td>${book.getName()}</td>
            <td>${book.getPublisher()}</td>
                <%--<td>${book.getImage_path()}</td>--%>
            <td>${book.getPrice()}</td>
            <td>${book.getCategory()}</td>
                <input type="hidden" name="id" value="${book.getId()}">
                <td><input type="submit" value="下架" class="lightblue"></td>
            <%--<td>${book.seller}</td>--%>
            </form>
        </tr>
    </c:forEach>
    </table>
    <br><br>

    <table border='1' cellspacing='0'>
        <captain class="headline">已完成订单</captain>
        <tr class="firstline">
            <td>名字</td>
            <td>出版社</td>
            <td>图书类型</td>
            <td>卖家</td>
            <td>买家</td>
            <td>价钱</td>
        </tr>

        <c:forEach items="${finishs}" var = "finish" varStatus="st">
            <tr class="content">
                    <td>${finish.getName()}</td>
                    <td>${finish.getPublisher()}</td>
                    <td>${finish.getCategory()}</td>
                    <td>${finish.getSeller()}</td>
                    <td>${finish.getBuyer()}</td>
                    <td>${finish.getPrice()}</td>
            </tr>
        </c:forEach>
    </table>
</center>
</body>
</html>
<%--<script language="JavaScript">--%>
    <%--$(function(){--%>
        <%--$("#name").keyup(function(){--%>
            <%--var page = "/study/checkName.jsp";--%>
            <%--var value = $(this).val();--%>

            <%--$.post(--%>
                <%--page,--%>
                <%--{"name":value},--%>
                <%--function(result){--%>
                    <%--$("#checkResult").html(result);--%>
                <%--}--%>
            <%--);--%>
        <%--});--%>
    <%--});--%>
<%--</script>--%>
<script>
    function changeInformation()
    {
        var select = confirm("是否确认修改?");
        return select;
    }
</script>

<script>
    function deleteBook()
    {
        var select = confirm("是否下架此书？");
       return select;
    }
</script>