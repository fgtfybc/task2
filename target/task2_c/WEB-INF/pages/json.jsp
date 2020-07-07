<%@ page language="java" contentType="text/html; charset=UTF-8"pageEncoding="UTF-8"%>
<%@ taglib prefix ="json" uri ="http://www.atg.com/taglibs/json"%>
<html>
<head>
    <title>用户</title>
</head>
<body>
<json:object>
    ID:<json:property name="id" value="${student.id}"/></br>
    姓名：<json:property name="name" value="${student.name}"/></br>
    QQ:<json:property name="qq" value="${student.qq}"/></br>
    类型：<json:property name="type" value="${student.subject}"/></br>
    入学时间：<json:property name="time" value="${student.jionTime}"/></br>
    师兄：<json:property name="stunum" value="${student.instructor}"/></br>
    来自：<json:property name="daily" value="${student.knowFrom}"/></br>
    立志：<json:property name="wish" value="${student.wish}"/></br>
    创建时间：<json:property name="senior" value="${student.createAt}"/></br>
    更新于：<json:property name="senior" value="${student.updateAt}"/></br>
</json:object>
</body>
</html>
