<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% String path=request.getContextPath();
    String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";%>
<%--
  Created by IntelliJ IDEA.
  User: 92329
  Date: 2019/8/2
  Time: 12:25
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html; charset=utf-8" pageEncoding="utf-8" isErrorPage="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>失败啦失败啦失败啦</title>
</head>
<body>
<h1>添加失败<h1>
    <tr>
        提示信息
        ${error}
    </tr>
</body>
</html>