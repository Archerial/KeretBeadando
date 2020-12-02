<%--
  Created by IntelliJ IDEA.
  User: Adam
  Date: 2020. 11. 30.
  Time: 8:07
  To change this template use File | Settings | File Templates.
--%>



<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>




<html style="background: linear-gradient(90deg, #69b7eb, #b3dbd3, #00FF7F)">
<head>
    <title>Title</title>
</head>
<body style="text-align: center", topmargin="100px">
<h3>Add student</h3><br>
<form:form method="post" action="addStudent" modelAttribute="student">
    <form:label path="name">Name</form:label> <br>
        <form:input path="name"/> <br><br>
    <form:label path="id">Neptun code</form:label> <br>
        <form:input path="id"/> <br><br>
    <form:label path="birth_date">Birth date</form:label> <br>
        <form:input type="date" path="birth_date"/> <br><br>
    <form:label path="passed_semesters">Passed semesters</form:label> <br>
        <form:input path="passed_semesters"/> <br><br>
    <form:label path="department">Department</form:label> <br>
        <form:select path="department">
            <form:options items="${department}"></form:options>
        </form:select> <br><br>
    <input type="submit" value="Submit"/>


</form:form>


</body>
</html>
