<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/4/29
  Time: 16:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="DAO.CategoryDAO" %>
<%@ page import="DAO.UserDAO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@include file="include_login_message.jsp"%>
<html>
<head>
    <meta content="text/html;charset=UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
    <title>支付界面</title>
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
    <%--<a>图书信息</a>--%>
    <%--name:<a>${book.getName()}</a><br>--%>
    <%--publisher:<a>${book.getPublisher()}</a><br>--%>
    <%--category:<a>${category}</a><br>--%>
    <%--seller:<a>${seller}</a><br>--%>
    <%--price:<a>${book.getPrice()}</a><br>--%>
    <table border="1" cellspacing="0">
        <captain class="headline">图书信息</captain>
        <tr class="content">
            <td>名字</td>
            <td>${book.getName()}</td>
        </tr>
        <tr class="content">
            <td>出版社</td>
            <td>${book.getPublisher()}</td>
        </tr>
        <tr class="content">
            <td>图书类型</td>
            <td>${book.getCategory()}</td>
        </tr>
        <tr class="content">
            <td>卖家</td>
            <td>${book.getSeller()}</td>
        </tr>
        <tr class="content">
            <td>价钱</td>
            <td>${book.getPrice()}</td>
        </tr>
    </table>
</center>
<form action="paid" method="post">
    <center>
        <input type="hidden" name="id" value="${book.getId()}">
        <br><br>收货人姓名：<input type="text" name="receiver_name" value="<%=session.getAttribute("name")%>" class="deepblue">
        <br><br>收货人电话：<input type="text" name="phone_number" value="<%=new UserDAO().getCurrentUser((String) session.getAttribute("name")).getPhone_number()%>" class="deepblue">
        <br><br>收货人地址：<input type="text" name="address" value="<%=new UserDAO().getCurrentUser((String) session.getAttribute("name")).getAddress()%>" class="deepblue">
        <br><br><br>
        <a>(此处应插入一个微信支付二维码)</a>
        <br><br>
        <br><input type="submit" value="已完成付款" class="lightblue">
<%--<input type="text" value="${new UserDAO().getCurrentUser()}">--%>
    </center>
<%--调用微信支付接口功能，将书本的价格作为参数传过去，买家直接扫码支付，支付完成后点击按钮，判断支付完后跳转--%>
</form>
</body>
</html>
