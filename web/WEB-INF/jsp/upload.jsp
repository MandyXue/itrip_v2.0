<%--
  Created by IntelliJ IDEA.
  User: AngelYang
  Date: 2015/6/10
  Time: 8:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<form action="UpLoadServlet" enctype="multipart/form-data" method="post">
    选择文件<input type="file" name="file1" id="file1">
    <input type="submit" name="upload" value="上传">
</form>
</body>
</html>
