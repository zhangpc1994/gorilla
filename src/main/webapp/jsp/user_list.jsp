<%--
  Created by IntelliJ IDEA.
  User: XH
  Date: 2016/5/13
  Time: 11:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title></title>

</head>
<body>
<div align="center">
  <h1>用户列表页</h1><a href="jsp/addUser.jsp">添加</a>
  <table>
    <tr>
      <td>用户名</td>
      <td>密码</td>
      <%--<td>操作</td>--%>
    </tr>
    <c:forEach items="${userList}" var="user">
      <tr>
        <td>${user.username}</td>
        <td>${user.password}</td>
        <%--<td><a href="userList?deleteUserName=${user.username}">删除</a></td>--%>
      </tr>

    </c:forEach>
  </table>
</div>
</body>
</html>
