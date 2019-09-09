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
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@include file="include_login_message.jsp"%>
<html>
<head>
    <title>个人中心</title>
</head>
<body>
<% User user = new UserDAO().getCurrentUser((String) session.getAttribute("name"));%>
<center>
    <form action="/update_user" method="post" onsubmit="return changeInformation()">
<table border='1' cellspacing='0'>
    <captain>个人信息</captain>
    <tr>
        <td><center>attribute</center></td>
        <td><center>value</center></td>
    </tr>


    <tr>
        <td>name</td>
        <td><%=user.getName()%></td>
    </tr>
    <tr>
        <td>school</td>
        <td><%=user.getSchool()%></td>
    </tr>
    <tr>
        <td>number</td>
        <td><%=user.getNumber()%></td>
    </tr>
    <tr>
        <td>password</td>
        <td><input type="password" value="<%=user.getPassword()%>" name="password"></td>
    </tr>
    <tr>
        <td>address</td>
        <td><input type="text" value="<%=user.getAddress()%>" name="address"></td>
    </tr>
    <tr>
        <td>phone_number</td>
        <td><input type="text" value="<%=user.getPhone_number()%>" name="phone_number"></td>
    </tr>
</table>
    <input type="submit" align="center" onsubmit="return changeInformation()" value="保存更改">
    </form>
    <br><br>

    <%--插入一个此账号在售图书列表--%>
    <table border='1' cellspacing='0'>
    <captain>在售图书</captain>
    <tr>
        <%--<td>id</td>--%>
        <td>name</td>
        <td>publisher</td>
        <%--<td>image_path</td>--%>
        <td>price</td>
        <td>category</td>
        <td>operation</td>
        <%--<td>seller</td>--%>
    </tr>
    <c:forEach items="${books}" var = "book" varStatus="st">
        <tr>
            <form action="/delete_book?id=${book.getId()}" onsubmit="return deleteBook()" method="post">
            <%--<td>${book.getId()}</td>--%>
            <td>${book.getName()}</td>
            <td>${book.getPublisher()}</td>
                <%--<td>${book.getImage_path()}</td>--%>
            <td>${book.getPrice()}</td>
            <td>${book.category}</td>
                <td><input type="submit" value="下架"></td>
            <%--<td>${book.seller}</td>--%>
            </form>
        </tr>
    </c:forEach>
    </table>
    <br><br>

    <table border='1' cellspacing='0'>
        <captain>已完成订单</captain>
        <tr>
            <td>name</td>
            <td>publisher</td>
            <td>category</td>
            <td>seller</td>
            <td>buyer</td>
            <td>price</td>
        </tr>

        <c:forEach items="${finishs}" var = "finish" varStatus="st">
            <tr>
                    <td>${finish.getName()}</td>
                    <td>${finish.getPublisher()}</td>
                    <td>${finish.category}</td>
                    <td>${finish.seller}</td>
                    <td>${finish.buyer}</td>
                    <td>${finish.getPrice()}</td>
            </tr>
        </c:forEach>
    </table>
</center>
</body>
</html>
<script language="JavaScript">
    $(function(){
        $("#name").keyup(function(){
            var page = "/study/checkName.jsp";
            var value = $(this).val();

            $.post(
                page,
                {"name":value},
                function(result){
                    $("#checkResult").html(result);
                }
            );
        });
    });
</script>
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