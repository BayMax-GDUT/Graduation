<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/5/26
  Time: 15:16
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
    <title>完成订单查询</title>
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
<center>
    <form action="manager_search" align="center">
        <input type="text" name="name" value="" class="search-kuang" placeholder="图书名">
        <input type="hidden" name="hidden" value="sold_book">
        &nbsp;&nbsp;&nbsp;&nbsp;
        <input type="submit" value="搜索" class="search-button">
    </form>
<table border="1" cellspacing="0">
    <caption class="headline">订单列表</caption>
    <tr class="firstline">
        <td>id</td>
        <td>名字</td>
        <td>出版社</td>
        <td>图书类型</td>
        <td>卖家</td>
        <td>买家</td>
        <td>价钱</td>
        <td>收货人</td>
        <td>收货地址</td>
        <td>联系方式</td>
    </tr>
    <c:forEach items="${sold_books}" var = "sold_book" varStatus="st">
        <tr class="content">
            <td>${sold_book.getId()}</td>
            <td>${sold_book.getName()}</td>
            <td>${sold_book.getPublisher()}</td>
            <td>${sold_book.getCategory()}</td>
            <td>${sold_book.getSeller()}</td>
            <td>${sold_book.getBuyer()}</td>
            <td>${sold_book.getPrice()}</td>
            <td>${sold_book.getReceiver_name()}</td>
            <td>${sold_book.getAddress()}</td>
            <td>${sold_book.getPhone_number()}</td>
        </tr>
    </c:forEach>
</table>
</center>
</body>
</html>
