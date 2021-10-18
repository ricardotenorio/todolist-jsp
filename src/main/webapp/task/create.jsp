<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create task for ${ project.name }</title>
</head>
<body>
	
	<header>
		<h3>Create task for ${ project.name }</h3>
	</header>
	
	<form action="" method="post">
		<label for="task-name">Name</label>
		<input id="task-name" type="text" name="name">
		<label for="task-description">Description</label>
		<input id="task-description" type="text" name="description">
		<label for="task-date">Due date</label>
		<input id="task-date" type="date" name="date">
		
		<button type="submit">Create</button>
	</form>
	
</body>
</html>