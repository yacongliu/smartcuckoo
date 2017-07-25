<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/common/global.jsp" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <title>用户注册</title>
    <meta name="keywords" content="">
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <link rel="shortcut icon" href="${staticPath }/assets/img/favicon.ico">
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.css" rel="stylesheet">
    <link rel="stylesheet" href="${staticPath }/assets/css/signin.css" charset="utf-8">
</head>
<body>
<div class="container">
    <form action="#" class="form-signup">
        <h3> Create your account</h3>
        <input type="text" name="username" class="form-control" placeholder="Username" required autofocus><br>
        <input type="text" name="email" class="form-control" placeholder="Email Adress" required><br>
        <input type="password" name="password" class="form-control" placeholder="Password" required><br>
        <input type="text" name="company" class="form-control" placeholder="Company"><br>
        <button type="submit" class="btn btn-primary btn-primary btn-lg btn-block">Sign up</button>
        <div class="link">
            <br>
            <a href="${path }/login.jsp" class="btn btn-link">Sign in</a>
            <br>
        </div>
    </form>
</div>

<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>
