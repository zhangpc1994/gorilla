<%--
  Created by IntelliJ IDEA.
  User: XH
  Date: 2016/5/17
  Time: 15:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<div align="center">
  <form action="../userList?updateUserName=<%=request.getParameter("updateUserName")%>" method="post">
    用户名：<input type="text" name="updateUserName" value="<%=request.getParameter("updateUserName")%>" readonly/><br>
    密码：<input type="text" name="updatePassword" value=""/><br>
    <input type="submit" value="修改"><input type="reset" value="重置">
  </form>
</div>
</body>
</html>
