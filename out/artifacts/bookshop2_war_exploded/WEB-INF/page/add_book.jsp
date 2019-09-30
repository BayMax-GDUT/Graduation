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
    <meta name="viewport" content="width=device-width,initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
    <title>新增出售</title>
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
<form action = "submit_add_book" method="post">
    <%--当前用户:<%=session.getAttribute("name")%><br>--%>
    <br><br><input type="text" name="name" class="deepblue" placeholder="&nbsp;&nbsp;图书名">
    <br><br><input type="text" name="publisher" class="deepblue" placeholder="&nbsp;&nbsp;出版社">
    <br><br><input type="text" name="price" class="deepblue" placeholder="&nbsp;&nbsp;售价">
        <br><br>
    <select name="category_id">
                    <c:forEach items="${categories}" var = "category" varStatus="st">
                        <option value="${category.getId()}">${category.getChinese()}</option>
    <%--<option value="1">数学</option>--%>
    <%--<option value="2">英语</option>--%>
    <%--<option value="3">计算机</option>--%>
    <%--<option value="4">机械</option>--%>
    <%--<option value="5">其他</option>--%>
                    </c:forEach>
                </select><br><br>
    <!--上传图书图片功能未实现-->
    <%--根据当前登录用户进行id获取功能在控制器中实现--%>
    <input type="submit" value="提交" class="lightblue"><br>
</form>
</center>
</body>
</html>
