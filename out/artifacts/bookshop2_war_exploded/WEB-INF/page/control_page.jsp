<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/5/7
  Time: 17:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="include_manager_login_message.jsp"%>
<html>
<head>
    <meta content="text/html;charset=UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
    <title>管理员后台</title>
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
<body align="center">
<%--用户管理表格--%>

<%--封禁用户管理表格--%>

<%--图书管理表格--%>

<%--图书类型管理表格--%>

<%--已完成订单查看表格--%>



<%--用户管理表格--%>
<%--<center>--%>
<%--<table border='1' cellspacing='0'>--%>
    <%--<captain>用户名单</captain>--%>
    <%--<tr>--%>
        <%--<td>id</td>--%>
        <%--<td>姓名</td>--%>
        <%--<td>学校</td>--%>
        <%--<td>学号</td>--%>
        <%--<td>地址</td>--%>
        <%--<td>联系方式</td>--%>
        <%--<td>操作</td>--%>
    <%--</tr>--%>
    <%--<c:forEach items="${users}" var = "user" varStatus="st">--%>
        <%--<tr>--%>
            <%--<form action="/ban_user"  method="post" onsubmit="return ban_user()">--%>
                    <%--&lt;%&ndash;<td>${book.getId()}</td>&ndash;%&gt;--%>
                <%--<td>${user.getId()}</td>--%>
                <%--<td>${user.getName()}</td>--%>
                <%--<td>${user.getSchool()}</td>--%>
                <%--<td>${user.getNumber()}</td>--%>
                <%--<td>${user.getAddress()}</td>--%>
                <%--<td>${user.getPhone_number()}</td>--%>
                <%--<td><input type="submit" value="封禁" ></td>--%>
                <%--<input type="hidden" name="id" value="${user.getId()}">--%>
            <%--</form>--%>
        <%--</tr>--%>
    <%--</c:forEach>--%>
<%--</table>--%>
    <%--</center>--%>
<%--<script>--%>
    <%--function ban_user(){--%>
        <%--return confirm("是否确认封禁此用户？");--%>
    <%--}--%>
<%--</script>--%>
<%--<br><br><br><br>--%>

<%--&lt;%&ndash;封禁用户管理表格&ndash;%&gt;--%>
<%--<center>--%>
<%--<table border='1' cellspacing='0'>--%>
    <%--<captain>封禁名单</captain>--%>
    <%--<tr>--%>
        <%--<td>id</td>--%>
        <%--<td>姓名</td>--%>
        <%--<td>学校</td>--%>
        <%--<td>学号</td>--%>
        <%--<td>地址</td>--%>
        <%--<td>联系方式</td>--%>
        <%--<td>原因</td>--%>
        <%--<td>操作人</td>--%>
        <%--<td>日期</td>--%>
        <%--<td>操作</td>--%>
    <%--</tr>--%>
    <%--<c:forEach items="${ban_users}" var = "ban_user" varStatus="st">--%>
        <%--<tr>--%>
            <%--<form action="/unban_user"  method="post" onsubmit="return unban_user()">--%>
                    <%--&lt;%&ndash;<td>${book.getId()}</td>&ndash;%&gt;--%>
                <%--<td>${ban_user.getId()}</td>--%>
                <%--<td>${ban_user.getName()}</td>--%>
                <%--<td>${ban_user.getSchool()}</td>--%>
                <%--<td>${ban_user.getNumber()}</td>--%>
                <%--<td>${ban_user.getAddress()}</td>--%>
                <%--<td>${ban_user.getPhone_number()}</td>--%>
                <%--<td>${ban_user.getReason()}</td>--%>
                <%--<td>${ban_user.getManager()}</td>--%>
                <%--<td>${ban_user.getDate()}</td>--%>
                <%--<td><input type="submit" value="解封" ></td>--%>
                <%--<input type="hidden" name="id" value="${ban_user.getId()}">--%>
            <%--</form>--%>
        <%--</tr>--%>
    <%--</c:forEach>--%>
<%--</table>--%>
<%--</center>--%>
<%--<script>--%>
    <%--function unban_user()--%>
    <%--{--%>
        <%--return confirm("是否确认解封此用户？");--%>
    <%--}--%>
<%--</script>--%>
<%--<br><br><br><br>--%>

<%--&lt;%&ndash;图书管理表格&ndash;%&gt;--%>
<%--<center>--%>
<%--<table border='1' cellspacing='0'>--%>
    <%--<captain>图书清单</captain>--%>
    <%--<tr>--%>
        <%--<td>id</td>--%>
        <%--<td>名字</td>--%>
        <%--<td>出版社</td>--%>
        <%--<td>图书类型</td>--%>
        <%--<td>卖家</td>--%>
        <%--<td>价钱</td>--%>
        <%--<td>操作</td>--%>
    <%--</tr>--%>
    <%--<c:forEach items="${books}" var = "book" varStatus="st">--%>
        <%--<tr>--%>
            <%--<form action="/delete_book"  method="post" onsubmit="delete_book()">--%>
                    <%--&lt;%&ndash;<td>${book.getId()}</td>&ndash;%&gt;--%>
                <%--<td>${book.getId()}</td>--%>
                <%--<td>${book.getName()}</td>--%>
                <%--<td>${book.getPublisher()}</td>--%>
                <%--<td>${book.getCategory()}</td>--%>
                <%--<td>${book.getSeller()}</td>--%>
                <%--<td>${book.getPrice()}</td>--%>
                <%--<td><input type="submit" value="下架" ></td>--%>
                <%--<input type="hidden" name="id" value="${book.getId()}">--%>
            <%--</form>--%>
        <%--</tr>--%>
    <%--</c:forEach>--%>
<%--</table>--%>
<%--</center>--%>
<%--<script>--%>
    <%--function delete_book() {--%>
        <%--return confirm("是否确认下架此书？");--%>
    <%--}--%>
<%--</script>--%>
<%--<br><br><br><br>--%>


<%--&lt;%&ndash;图书类型管理表格&ndash;%&gt;--%>
<%--<center>--%>
<%--<table border='1' cellspacing='0'>--%>
    <%--<captain>图书类型表</captain>--%>
    <%--<tr>--%>
        <%--<td>id</td>--%>
        <%--<td>name</td>--%>
        <%--<td>chinese</td>--%>
    <%--</tr>--%>
    <%--<c:forEach items="${categories}" var = "category" varStatus="st">--%>
        <%--<tr>--%>
            <%--&lt;%&ndash;<form action="/ban_user"  method="post">&ndash;%&gt;--%>
                    <%--&lt;%&ndash;<td>${book.getId()}</td>&ndash;%&gt;--%>
                <%--<td>${category.getId()}</td>--%>
                <%--<td>${category.getName()}</td>--%>
                <%--<td>${category.getChinese()}</td>--%>
                <%--&lt;%&ndash;<td><input type="submit" value="下架"></td>&ndash;%&gt;--%>
                <%--&lt;%&ndash;<input type="hidden" name="id" value="${category.getId()}">&ndash;%&gt;--%>
            <%--&lt;%&ndash;</form>&ndash;%&gt;--%>
        <%--</tr>--%>
    <%--</c:forEach>--%>
<%--</table>--%>
    <%--<input type="button" value="增加图书类型" onclick="add_category()">--%>
    <%--<script>--%>
        <%--function add_category()--%>
        <%--{--%>
            <%--window.location = "/add_category";--%>
        <%--}--%>
    <%--</script>--%>
<%--</center>--%>

<%--<br><br><br><br>--%>

<%--<center>--%>
<%--<table border="1" cellspacing="0">--%>
    <%--<caption>订单列表</caption>--%>
        <%--<tr>--%>
            <%--<td>id</td>--%>
            <%--<td>名字</td>--%>
            <%--<td>出版社</td>--%>
            <%--<td>图书类型</td>--%>
            <%--<td>卖家</td>--%>
            <%--<td>买家</td>--%>
            <%--<td>价钱</td>--%>
            <%--<td>收货人</td>--%>
            <%--<td>收货地址</td>--%>
            <%--<td>联系方式</td>--%>
        <%--</tr>--%>
<%--<c:forEach items="${sold_books}" var = "sold_book" varStatus="st">--%>
            <%--<tr>--%>
                <%--<td>${sold_book.getId()}</td>--%>
                <%--<td>${sold_book.getName()}</td>--%>
                <%--<td>${sold_book.getPublisher()}</td>--%>
                <%--<td>${sold_book.getCategory()}</td>--%>
                <%--<td>${sold_book.getSeller()}</td>--%>
                <%--<td>${sold_book.getBuyer()}</td>--%>
                <%--<td>${sold_book.getPrice()}</td>--%>
                <%--<td>${sold_book.getReceiver_name()}</td>--%>
                <%--<td>${sold_book.getAddress()}</td>--%>
                <%--<td>${sold_book.getPhone_number()}</td>--%>
            <%--</tr>--%>
<%--</c:forEach>--%>
<%--</table>--%>
<%--</center>--%>
<%--<br><br><br><br>--%>
</body>
</html>
