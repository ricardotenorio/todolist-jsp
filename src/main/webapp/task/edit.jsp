<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit ${ task.name }</title>
</head>
<body>
	
	<header>
		<h3>Edit ${ task.name }</h3>
	</header>
	
	<form action="" method="post">
		<label for="task-name">Name</label>
		<input id="task-name" type="text" name="name" value="${ task.name }">
		<label for="task-description">Description</label>
		<input id="task-description" type="text" name="description" value="${ task.description }">
		<label for="task-date">Due date</label>
		<input id="task-date" type="date" name="date" value="${ task.dueDate }">
		<label for="task-status">Completed</label>
		<input id="task-status" type="checkbox" name="status" 
			${ completed ? "checked" : "" }>
		
		<button type="submit">Save</button>
	</form>
	
</body>
</html>