<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016-05-15
  Time: 上午 10:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>股票详情</title>
</head>
<body>
<div align="center">
    <h1>股票详情</h1>
    <form action="stockUpdate" method="post">
      股票代码：<input type="text" name="stockCode" value="${stock.stockCode}" readonly/><br>
      股票名称：<input type="text" name="stockName" value="${stock.stockName}"/><br>
      开盘价：<input type="text" name="openPrice" value="${stock.openPrice}"/><br>
      当前价：<input type="text" name="nowPrice" value="${stock.nowPrice}"/><br>
      涨幅：<input type="text" name="change" value="${stock.change}"/><br>
      <input type="button" name="button" id="button" onclick="history.back(-1)" value="返回">
    </form>
</div>
</body>
</html>
