<%--
  Created by IntelliJ IDEA.
  User: XH
  Date: 2016/5/13
  Time: 16:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>股票列表</title>
    <script type="text/javascript">
        function page(){
            //总页数
            var counts  = <%=request.getAttribute("totalPage")%>
            for(var i=0;i<counts;i++){
                var objdiv = document.createElement("page");
                objdiv .innerHTML = i+1;
                document.body.appendChild(objdiv );
            }
        }


    </script>
</head>
<body onload="page()">
<div align="center">
    <h1>股票列表</h1>
    <table border="1px" cellpadding="0" cellspacing="0">
        <tr>
            <td width="70px">股票代码</td>
            <td width="100px">股票名称</td>
            <td width="80px">开盘价</td>
            <td width="80px">当前价</td>
            <td width="50px">涨幅</td>
            <td width="100px">操作</td>
        </tr>

        <c:forEach items="${pageStock}" var="stock">
            <form action="stockShow" method="post">
                <input type="hidden" id="stockCode" name="stockCode" value="${stock.stockCode}"/>
                <input type="hidden" id="stockName" name="stockName" value="${stock.stockName}"/>
                <input type="hidden" id="openPrice" name="openPrice" value="${stock.openPrice}"/>
                <input type="hidden" id="nowPrice" name="nowPrice" value="${stock.nowPrice}"/>
                <input type="hidden" id="change" name="change" value="${stock.change}"/>
                <tr>
                    <%--<td><a method="get" href="stockShow?stockCode=${stock.stockCode}&stockName=${stock.stockName}&openPrice=${stock.openPrice}&nowPrice=${stock.nowPrice}&change=<c:out value='${stock.change}'></c:out>">${stock.stockCode}</a></td>--%>
                    <td><a href='<c:url value="stockShow">
                        <c:param name="stockCode" value="${stock.stockCode}"></c:param>
                        <c:param name="stockName" value="${stock.stockName}"></c:param>
                        <c:param name="openPrice" value="${stock.openPrice}"></c:param>
                        <c:param name="nowPrice" value="${stock.nowPrice}"></c:param>
                        <c:param name="change" value="${stock.change}"></c:param>
                    </c:url>'>${stock.stockCode}</a></td>
                    <td>${stock.stockName}</td>
                    <td>${stock.openPrice}</td>
                    <td>${stock.nowPrice}</td>
                    <td>${stock.change}</td>
                    <td><input type="submit" value="查看"/></td>

                </tr>
            </form>
        </c:forEach>
    </table>
    第${page.pageNow}页/${page.totalPage}页
    <a href="stock?pageNow=1">首页</a>
    <c:if test="${page.pageNow>1}"><a href="stock?pageNow=${page.pageNow-1}">上一页</a></c:if>
    <span id="page"></span>
    <c:if test="${page.pageNow<page.totalPage}"><a href="stock?pageNow=${page.pageNow+1}">下一页</a></c:if>
    <a href="stock?pageNow=${page.totalPage}">尾页</a>
</div>
</body>
</html>
