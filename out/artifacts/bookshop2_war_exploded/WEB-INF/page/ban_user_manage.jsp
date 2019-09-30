<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/5/26
  Time: 15:04
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
    <title>封禁用户管理</title>
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
        <input type="text" name="name" value="" class="search-kuang" placeholder="用户名">
        <input type="hidden" name="hidden" value="ban_user">
        &nbsp;&nbsp;&nbsp;&nbsp;
        <input type="submit" value="搜索" class="search-button">
    </form>
<table border='1' cellspacing='0'>
    <captain class="headline">封禁名单</captain>
    <tr class="firstline">
        <td>id</td>
        <td>姓名</td>
        <td>学校</td>
        <td>学号</td>
        <td>地址</td>
        <td>联系方式</td>
        <td>原因</td>
        <td>操作人</td>
        <td>日期</td>
        <td>操作</td>
    </tr>
    <c:forEach items="${ban_users}" var = "ban_user" varStatus="st">
        <tr class="content">
            <form action="/unban_user"  method="post" onsubmit="return unban_user()">
                    <%--<td>${book.getId()}</td>--%>
                <td>${ban_user.getId()}</td>
                <td>${ban_user.getName()}</td>
                <td>${ban_user.getSchool()}</td>
                <td>${ban_user.getNumber()}</td>
                <td>${ban_user.getAddress()}</td>
                <td>${ban_user.getPhone_number()}</td>
                <td>${ban_user.getReason()}</td>
                <td>${ban_user.getManager()}</td>
                <td>${ban_user.getDate()}</td>
                <td><input type="submit" value="解封" class="lightblue"></td>
                <input type="hidden" name="id" value="${ban_user.getId()}">
            </form>
        </tr>
    </c:forEach>

</table>
</table>
</center>>
<script>
    function unban_user()
    {
        return confirm("是否确认解封此用户？");
    }
</script>
</body>
</html>
