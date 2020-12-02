<%--
  Created by IntelliJ IDEA.
  User: Adam
  Date: 2020. 11. 30.
  Time: 7:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false"%>

<html style="background: linear-gradient(90deg, #69b7eb, #b3dbd3, #00FF7F)">
<head>
    <title>${student.id}</title>
</head>
<body style="text-align: center", topmargin="100px">
<p>Personal datas</p>
<table>
    <tr><td>Name:</td><td>${student.name}</td></tr>
    <tr><td>Birth date:</td><td>${student.birth_date}</td></tr>
    <tr><td>Neptun code:</td><td>${student.id}</td></tr>
    <tr><td>Department:</td><td>${student.department}</td></tr>
    <tr><td>Passed semesters:</td><td>${student.passed_semesters}</td></tr>
    <tr><td>Language knowledge:</td><td>${student.languageKnowledge}</td></tr>
</table>
<form action="${pageContext.servletContext.contextPath}/">
    <input type="submit" value="Home">
</form>
</body>
</html>
