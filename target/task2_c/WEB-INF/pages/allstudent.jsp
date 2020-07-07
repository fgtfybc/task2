<%@page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<br>
你想添加用户吗？ 请点击这里：<a href = "/student/add"  >添加用户</a>
</br>
<td>
<td>
    <table align="center" border="1" cellspacing="0">
        <tr>
            <td>id</td>
            <td>name</td>
            <td>qq</td>
            <td>subject</td>
            <td>jionTime</td>
            <td>instructor</td>
            <td>knowFrom</td>
            <td>wish</td>
            <td>createAt</td>
            <td>updateAt</td>
            <td>修改</td>
            <td>删除</td>
        </tr>
        <%--//接收controller给出的model数据--%>
        <%--c标签里封装了java循环语法--%>
        <c:forEach items ="${list}" var="Student">
            <tr>
                <td>${Student.id}</td>
                <td>${Student.name}</td>
                <td>${Student.qq}</td>
                <td>${Student.subject}</td>
                <td>${Student.joinTime}</td>
                <td>${Student.instructor}</td>
                <td>${Student.knowFrom}</td>
                <td>${Student.wish}</td>
                <td>${Student.createAt}</td>
                <td>${Student.updateAt}</td>
                <td><a href="/student/up/${Student.id}">修改</a></td>
                <td><a href="/student/delete/${Student.id}">删除</a></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>