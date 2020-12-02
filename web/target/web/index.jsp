<%@ page isELIgnored="false"%>
<html style="background: linear-gradient(90deg, #69b7eb, #b3dbd3, #00FF7F)">
<body style="text-align: center", topmargin="100px">
<h2>Welcome!</h2>
<p>To list the students, click the button bellow</p>
<br><br>
<form action="${pageContext.servletContext.contextPath}/students">
    <input type="submit" value="Students">
</form>
</body>
</html>
