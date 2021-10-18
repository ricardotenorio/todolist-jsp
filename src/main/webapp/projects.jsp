<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Projects</title>
</head>
<body>
	
	<header>
		<h3>Projects</h3>
	</header>
	
	<a href="/todo-list/project/create">Create new project</a>
	
	<br>
	
	<c:forEach items="${ projects }" var="project">
		
		<a href="/view/${ project.id }">
			${ project.name }
		</a>
		${ project.createdAt }
		<a href="/todo-list/project/edit?id=${ project.id }">edit</a>
		<a href="/todo-list/project/delete?id=${ project.id }">delete</a>
		
		<br>
	</c:forEach>
	
</body>
</html>