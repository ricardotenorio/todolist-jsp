<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit ${ project.name }</title>
</head>
<body>

	<header>
		<h3>Edit ${ project.name }</h3>
	</header>

	<form action="" method="post">
		<label for="project-name">Name</label> 
		<input id="project-name" type="text" name="name" value="${ project.name }"> 
		
		<label for="project-description">Description</label>
		<input id="project-description" type="text" 
			name="description" value="${ project.description }">

		<button type="submit">Save</button>
	</form>

</body>
</html>