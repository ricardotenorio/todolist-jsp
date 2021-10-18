<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>${ project.name }</title>
</head>
<body>
	
	<header>
		<h3>${ project.name }</h3>
		<p>${ project.description }</p>
	</header>
	
	<br>
	
	<a href="/todo-list/task/create?id=${ project.id }">Create a new task</a>
	
	<br>
	<br>
	<br>
	
	<section>
		Tasks
		<br>
		<c:forEach items="${ tasks }" var="task">
			
			<a href="/todo-list/task/edit?id=${ task.id }">
				${ task.name }
				<br>
				${ task.description }
			</a>
			<br>
			${ task.dueDate }
			${ task.status }
			<a href="/todo-list/project/delete?id=${ task.id }">delete</a>
			
			<br>
			<br>
		</c:forEach>
	
	</section>
	
</body>
</html>