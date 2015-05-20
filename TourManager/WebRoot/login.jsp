<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
	<head>
	<meta content="text/html; charset=utf-8" http-equiv=Content-Type>
        <meta charset="utf-8">
        <title>旅行社信息管理系统</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">

        <!-- CSS -->
        <link rel="stylesheet" href="assets/css/reset.css">
        <link rel="stylesheet" href="assets/css/supersized.css">
        <link rel="stylesheet" href="assets/css/style.css">

        <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
        <!--[if lt IE 9]>
            <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->

    </head>

    <body onkeydown="keyLogin();">

        <div class="page-container">
            <h1>旅行社信息管理系统</h1>
            <form method="post" id="login" action="login.action">
                <input type="text" name="username" class="username" placeholder="请输入用户名">
                <input type="password" name="password" class="password" placeholder="请输入密码">
                <input type="text" name="validcode" class="validcode" placeholder="请输入验证码">
                <div><img class="validcode-img" src="createImageAction.action" onclick="this.src='createImageAction.action?'+ Math.random()" title="点击图片刷新验证码"/></div>
                <div id="loginMsg">${ login_msg }</div>
                <input class="button" type="button" value="登陆" onclick="login()" />
                
                <div class="error"><span>+</span></div>
            </form>
            
        </div>

        <!-- Javascript -->
        <script src="assets/js/jquery-1.8.2.min.js"></script>
        <script src="assets/js/supersized.3.2.7.min.js"></script>
        <script src="assets/js/supersized-init.js"></script>
        <script src="assets/js/scripts.js"></script>
        <script src="html/js/login.js"></script>

    </body>

</html>

