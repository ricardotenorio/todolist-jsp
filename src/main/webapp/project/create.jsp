<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create a new project</title>
</head>
<body>
	
	<header>
		<h3>Create a new project</h3>
	</header>
	
	<form action="" method="post">
		<label for="project-name">Name</label>
		<input id="project-name" type="text" name="name">
		<label for="project-description">Description</label>
		<input id="project-description" type="text" name="description">
		
		<button type="submit">Create</button>
	</form>
	
</body>
</html>