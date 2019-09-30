<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/5/10
  Time: 16:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <meta content="text/html;charset=UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
    <title>购买完成</title>
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
<body align="center">
<h3>购买成功</h3>
<form action="/list">
<br><h4>图书名：${sold_book.getName()}</h4>
<h4>出版社：${sold_book.getPublisher()}</h4>
<h4>图书类型：${sold_book.getCategory()}</h4>
<h4>卖家：${sold_book.getSeller()}</h4>
<h4>买家：${sold_book.getBuyer()}</h4>
<h4>价钱：${sold_book.getPrice()}</h4>
<h4>收货人姓名：${sold_book.getReceiver_name()}</h4>
<h4>收货人地址：${sold_book.getAddress()}</h4>
<h4>收货人电话：${sold_book.getPhone_number()}</h4>
<br>
<input type="submit" value="返回首页" class="lightblue">
</form>

</body>
</html>
