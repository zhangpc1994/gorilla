<%--
  Created by IntelliJ IDEA.
  User: XH
  Date: 2016/5/11
  Time: 10:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>模板页面</title>
<link rel="stylesheet" type="text/css" href="css/stock.css">
</head>
<body>
 <form id="tab">
   <div id="header">
     欢迎你 ${username}<input type="button" value="退出" onclick="location='login.jsp'"/>
     <a href="loginOut">退出</a>
   </div>
   <div id="main">
   <div id="operate">
     <h2>用户中心</h2>
     <ul class="hide">

       <li><a href="jsp/welcome.jsp" target="main-frm">首页</a></li>
       <li><a href="userList" target="main-frm">用户列表</a></li>
       <li><a href="stock" target="main-frm">股票信息</a></li>
     </ul>
   </div>
   <div id="data">
     <iframe id="main-frm" name="main-frm" frameborder="0" scrolling="yes" width="100%" height="100%" src="jsp/welcome.jsp"></iframe>
   </div>
   </div>
 </form>


</body>
</html>
