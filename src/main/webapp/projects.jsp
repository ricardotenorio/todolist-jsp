<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<header>
		<h3>Projects</h3>
	</header>
	
	${ projects }
	
	<jstl:forEach items="projects" var="project">
		${project}
	</jstl:forEach>
	
</body>
</html>