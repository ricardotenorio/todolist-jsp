package controller;

import java.io.IOException;
import java.time.LocalDateTime;

import entity.Project;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.ProjectService;

@WebServlet(
		name = "projectEdit",
		urlPatterns = "/project/edit"
		)
public class ProjectEditController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final ProjectService projectService = new ProjectService();
	Project projectToBeEdited;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		try {
			Long id = Long.parseLong(request.getParameter("id"));	
			projectToBeEdited = projectService.findProjectById(id);
			request.setAttribute("project", projectToBeEdited);
		} catch (Exception e) {	
			e.printStackTrace();
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("edit.jsp");
		
		dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String description = request.getParameter("description");
			
		projectToBeEdited.setName(name);
		projectToBeEdited.setDescription(description);
		
		try {
			projectService.updateProject(projectToBeEdited);
			
			response.sendRedirect("../");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
