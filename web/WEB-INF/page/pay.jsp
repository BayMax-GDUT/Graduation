<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/4/29
  Time: 16:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="DAO.CategoryDAO" %>
<%@ page import="DAO.UserDAO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>支付界面</title>
</head>
<body>
<center>
    <%--<a>图书信息</a>--%>
    <%--name:<a>${book.getName()}</a><br>--%>
    <%--publisher:<a>${book.getPublisher()}</a><br>--%>
    <%--category:<a>${category}</a><br>--%>
    <%--seller:<a>${seller}</a><br>--%>
    <%--price:<a>${book.getPrice()}</a><br>--%>
    <table>
        <captain>图书信息</captain>
        <tr>
            <td>name</td>
            <td>${book.getName()}</td>
        </tr>
        <tr>
            <td>publisher</td>
            <td>${book.getPublisher()}</td>
        </tr>
        <tr>
            <td>category</td>
            <td>${category}</td>
        </tr>
        <tr>
            <td>seller</td>
            <td>${seller}</td>
        </tr>
        <tr>
            <td>price</td>
            <td>${book.getPrice()}</td>
        </tr>
    </table>
</center>
<form method="post">
    <center>
        <a>收货人信息</a>
<input type="text" name="name" value="<%=session.getAttribute("name")%>">
<input type="text" name="phone_number" value="<%=new UserDAO().getCurrentUser((String) session.getAttribute("name")).getPhone_number()%>>">
<input type="text" name="address" value="<%=new UserDAO().getCurrentUser((String) session.getAttribute("name")).getAddress()%>">

        <%--此处应插入一个微信支付二维码--%>

<input type="submit" value="已完成付款">
<%--<input type="text" value="${new UserDAO().getCurrentUser()}">--%>

<%--调用微信支付接口功能，将书本的价格作为参数传过去，买家直接扫码支付，支付完成后点击按钮，判断支付完后跳转--%>
</form>
</body>
</html>
