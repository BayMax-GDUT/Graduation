<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/4/23
  Time: 13:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>注册用户</title>
</head>
<body align="center">
<form action="submit_add_user" method = "post">
    <a>${message}</a>
    账号：<input type = "text" name = "name"><br>
    密码：<input type = "password" name = "password"><br>
    学校：<input type = "text" name = "school"><br>
    学号：<input type = "text" name = "number"><br>
    地址：<input type = "text" name = "address"><br>
    电话：<input type="text" name = "phone_number"><br><br>

    <input type="submit" value="提交">
</form>
</body>
</html>
