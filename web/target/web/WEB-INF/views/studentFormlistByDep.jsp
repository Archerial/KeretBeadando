<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Adam
  Date: 2020. 12. 02.
  Time: 14:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false"%>
<html style="background: linear-gradient(90deg, #69b7eb, #b3dbd3, #00FF7F)">
    <title>Title</title>
</head>
    <body style="text-align: center", topmargin="100px">

<c:if test="${!empty students}">
    <table align="center" frame="border" rules="all">
        <tr><th>Neptun code</th><th>Name</th><th>Birth date</th></tr>
        <c:forEach items="${students}" var="stud">
            <tr><td><a href="${pageContext.servletContext.contextPath}/student/${stud.id}">${stud.id}</a></td><td>${stud.name}</td><td>${stud.birth_date}</td></tr>
        </c:forEach>
    </table>
</c:if>
<c:if test="${empty students}">
    <c:out value="There are no students in the database in this departament"/></c:if><br><br>

<form action="${pageContext.servletContext.contextPath}/students">
    <input type="submit" value="Home">
</form>


</body>
</html>
