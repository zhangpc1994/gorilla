<%--
  Created by IntelliJ IDEA.
  User: XH
  Date: 2016/5/13
  Time: 11:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <style>
    * {padding:0px; margin:0px;height:100%; width:100%;}
    .content  {padding-top:100px;box-sizing:border-box}
    .top {height:100px; width:100%;position:absolute; top:0px;}
    .left{ float:left;width:20%;}
    .right{ float:left;width:80%;}
    #top{height:100px;}
  </style>
</head>
<body>
<form id="top1">
<div class="content">
  <div class="top">
    <iframe src="jsp/stock_header.jsp"  scrolling="No"  id="top" noresize="noresize">
    </iframe>
  </div>
  <div class="main">
    <div class="left">
      <iframe src="jsp/stock_left.jsp" scrolling="No"  id="left" noresize="noresize">
      </iframe>
    </div>
    <div class="right">
      <iframe src="jsp/stock_main.jsp"  id="mainFrame" name="mainFrame" noresize="noresize" >
      </iframe>
    </div>
  </div>
</div>
</form>
</body>
</html>