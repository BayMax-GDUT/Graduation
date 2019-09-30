<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/4/25
  Time: 10:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" import="java.util.*" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta content="text/html;charset=UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
    <style type="text/css">
    .text{
        color:#ffffff;
    }
    </style>
</head>
<body align="right">

<%

//    被包含界面通过html语句声明格式会影响包含界面的格式
//    被包含界面不声明格式会沿用包含界面的格式
//    question：如何分别声明两个界面的格式

    if(session.getAttribute("name") != null)
    {
        out.print("<a class=\"text\">欢迎您，" + session.getAttribute("name") + "</a>");
        out.print("\t<input type=\"button\" value=\"个人中心\" onclick=\"location.href='/personal_page'\" class=\"lightblue\">");
        out.print("\t<input type=\"button\" onclick=\"logout()\" value=\"注销\" class=\"lightblue\">");
    }
    else
    {
        out.print("<input type=\"button\" value=\"登录\" onclick=\"location.href='login'\" class=\"lightblue\">\t");
        out.print("<input type=\"button\" value=\"注册\" onclick=\"location.href='/add_user'\" class=\"lightblue\">");
    }
    out.print("\t<input type=\"button\" value=\"首页\" onclick=\"location.href='/list'\" class=\"lightblue\">");
%>

</body>
</html>
<script type="text/javascript">
    function logout(){
        var answer = confirm("是否确认注销");//把确认框赋值给answer
        if(answer == true) //判断是否点击确定
        //注销后强制回到登录界面 通过游客模式登录会清除掉session数据
        //不通过游客模式会重新建立新的session数据
        {
            <%--<%session.removeAttribute("name");%>--%>
            window.location="/logout";
        }


    }
</script>


