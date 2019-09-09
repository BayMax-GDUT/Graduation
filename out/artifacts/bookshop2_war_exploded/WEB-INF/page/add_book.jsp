<%@ page import="bean.User" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/4/24
  Time: 0:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" import="java.util.*" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--<jsp:include page="loginMessage.jsp">--%>
    <%--<jsp:param name="user" value="${request.getSession().getAttribute("user")}" />--%>
<%--</jsp:include>--%>
<%@include file="include_login_message.jsp"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>新增出售</title>
</head>
<body>
<center>
<form action = "submit_add_book" method="post">
    <%--当前用户:<%=session.getAttribute("name")%><br>--%>
    图书名：    <input type="text" name="name">(必填)<br>
    出版社：    <input type="text" name="publisher">(必填)<br>
    &nbsp;&nbsp;售价：&nbsp;<input type="text" name="price">(必填)<br>
    类别：      <select name="category_id">
    <option value="1">数学</option>
    <option value="2">英语</option>
    <option value="3">计算机</option>
    <option value="4">机械</option>
    <option value="5">其他</option>
</select><br>
    <!--上传图书图片功能未实现-->
    <%--根据当前登录用户进行id获取功能在控制器中实现--%>
    <input type="submit" value="上传"><br>
</form>
</center>
</body>
</html>
