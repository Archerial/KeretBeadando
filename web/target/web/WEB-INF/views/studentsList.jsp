<%--
  Created by IntelliJ IDEA.
  User: Adam
  Date: 2020. 11. 30.
  Time: 7:14
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false"%>
<html style="background: linear-gradient(90deg, #69b7eb, #b3dbd3, #00FF7F)">
<head>
    <title>Students</title>
</head>
<body style="text-align: center", topmargin="100px">
<p>The students list:</p>
<c:if test="${!empty students}">
    <table align="center" frame="border" rules="all">
        <tr><th>Neptun code</th><th>Name</th><th>Birth date</th></tr>
    <c:forEach items="${students}" var="stud">
        <tr><td><a href="${pageContext.servletContext.contextPath}/student/${stud.id}">${stud.id}</a></td><td>${stud.name}</td><td>${stud.birth_date}</td></tr>
    </c:forEach>
        </table>
</c:if>
<c:if test="${empty students}">
    <c:out value="There are no students in the database"/></c:if>
<br><br>

<form action="${pageContext.servletContext.contextPath}/">
    <input type="submit" value="Home">
</form>
<p> To change datas </p>
<form action="${pageContext.servletContext.contextPath}/addStudent">
    <input type="submit" value="Add student">
</form>

<!-- Delete student:-->
<form action="${pageContext.servletContext.contextPath}/deleteStudent">
    <input type="submit" value="Delete student">
</form>
<!-- Update student: -->
<form action="${pageContext.servletContext.contextPath}/updateStudent">
    <input type="submit" value="Update student">
</form>
<br>
<p>Too se the students by departments</p>
<!-- List by departments#CS-->
<form action="${pageContext.servletContext.contextPath}/listByDep">
    <input type="submit" value="List student by department (CS)">
</form>
<!-- List by departments#BI-->
<form action="${pageContext.servletContext.contextPath}/listByDepBI">
    <input type="submit" value="List student by department (BI)">
</form>
<!-- List by departments#TM-->
<form action="${pageContext.servletContext.contextPath}/listByDepTM">
    <input type="submit" value="List student by department (TM)">
</form>
<!-- List by departments#1ITL-->
<form action="${pageContext.servletContext.contextPath}/listByDepITL">
    <input type="submit" value="List student by department (ITL)">
</form>



</body>
</html>
