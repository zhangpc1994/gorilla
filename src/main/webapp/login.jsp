<%--
  Created by IntelliJ IDEA.
  User: XH
  Date: 2016/5/13
  Time: 9:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>用户登录</title>
  <link type="text/css" rel="stylesheet" href="css/login_css.css">
  <script type="text/javascript">

    function checkUserName(){
      if(document.getElementById('username').value=='') {
        document.getElementById('username_span').innerHTML="请输入用户名";
        return false;
      }else{
        document.getElementById('username_span').innerHTML="";
      }
    }
    function checkPassWord(){
      if(document.getElementById('password').value=='') {
        document.getElementById('password_span').innerHTML="请输入密码";
        return false;
      }else{
        document.getElementById('password_span').innerHTML="";
      }
    }

    //提交验证
    function checkLogin(){
      if(document.getElementById('username').value=='') {
        document.getElementById('username_span').innerHTML="请输入用户名";
        return false;
      }
      if(document.getElementById('password').value=='') {
        document.getElementById('password_span').innerHTML="请输入密码";
        return false;
      }
    }

  </script>
</head>
<body id="body">
<h1>用户登录</h1>
  <form action="login" method="post" onsubmit="return checkLogin()">
    <span>${loginError}</span><br>
    <hr>
    <table align="center">
      <tr>
        <td align="rigth">用户名：<input type="text" value="admin" id="username" name="username" onblur="checkUserName()"/></td>
        <td align="left"><span id="username_span" class="span"></span></td>
      </tr>
      <tr>
        <td align="right">密码：<input type="password" value="123" id="password" name="password" onblur="checkPassWord()"/></td>
        <td align="left"><span id="password_span" class="span"></span></td>
      </tr>
    </table>
   <br>
    <br>
    <input type="submit" value="登录"/>
  </form>

</body>
</html>
