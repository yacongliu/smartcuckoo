<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/common/global.jsp" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <title>用户登录</title>
    <meta name="keywords" content="">
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <link rel="shortcut icon" href="${staticPath }/assets/img/favicon.ico">
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.css" rel="stylesheet">
    <link rel="stylesheet" href="${staticPath }/assets/css/signin.css" charset="utf-8">
</head>
<body>
<!--container start-->
<div class="container">
    <form action="#" class="form-signin">
        <h3>Please sign in</h3>
        <input type="text" name="username" id="inputUsername" class="form-control" placeholder="Username" required
               autofocus><br>
        <input type="password" name="password" id="inputPassword" class="form-control" placeholder="Password"
               required><br>
        <div class="check-box">
            <label>
                <input type="checkbox" name="remember-me" id="inputRemember-me"> Remember me
            </label>
        </div>
        <button class="btn btn-primary btn-primary btn-lg btn-block" type="submit" id="signin">Sign in</button>
        <div class="link">
            <br>
            <a href="${path }/signup.jsp" class="btn btn-link">Sign up</a>
            <br>
        </div>


    </form>
</div>
<!--container end-->


<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>
