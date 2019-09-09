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
<head></head>
<body align="right">

<%

//    被包含界面通过html语句声明格式会影响包含界面的格式
//    被包含界面不声明格式会沿用包含界面的格式
//    question：如何分别声明两个界面的格式

    if(session.getAttribute("name") != null)
    {
        out.print("欢迎您，" + "<a href=\"/personal_page\">" + session.getAttribute("name") + "</a>");
        out.print("\t<input type=\"button\" onclick=\"logout()\" onsubmit=\"return logout()\" value=\"注销\">");
    }
    else
    {
        out.print("<a href=\"/login\">登录</a>\t");
        out.print("<a href=\"/add_user\">注册</a>");
    }
%>

<%--<script type="text/javascript">--%>
    <%--function logout() {--%>
        <%--var mymessage = confirm("你喜欢JavaScript吗?");--%>
        <%--if (mymessage == true) {--%>
            <%--document.write("很好,加油!");--%>
        <%--} else {--%>
            <%--document.write("JS功能强大，要学习噢!");--%>
        <%--}--%>
    <%--}--%>
<%--</script>--%>
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


