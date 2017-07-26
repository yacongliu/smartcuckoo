<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/common/global.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <%@include file="/common/basejs.jsp" %>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>文件上传</title>
    <link rel="shortcut icon" href="${staticPath }/assets/img/favicon.ico">
</head>
<body>
   <form action="${path }/file/upload" method="post" enctype="multipart/form-data">
       <label>文件：</label>
       <input type="file" name="myfile"><br>
       <input type="submit" value="上传">

   </form>
</body>
</html>
