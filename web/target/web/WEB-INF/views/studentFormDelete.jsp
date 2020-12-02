<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Adam
  Date: 2020. 12. 02.
  Time: 11:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html style="background: linear-gradient(90deg, #69b7eb, #b3dbd3, #00FF7F)">
<head>
    <title>Title</title>
</head>
<body style="text-align: center", topmargin="100px">
<h3>Delete student by neptun code</h3><br><br>
<form:form method="post" action="deleteStudent" modelAttribute="student">
    <form:label path="id">Neptun code</form:label><br>
        <form:input path="id"/><br><br>
    <input type="submit" value="Submit"/>
</form:form>
</body>
</html>
