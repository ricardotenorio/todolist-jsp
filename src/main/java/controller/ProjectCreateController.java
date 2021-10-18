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
		name = "projectCreate",
		urlPatterns = "/project/create"
		)
public class ProjectCreateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final ProjectService projectService = new ProjectService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("project-create.jsp");
		
		dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String description = request.getParameter("description");
			
		Project createdProject = new Project();
		createdProject.setName(name);
		createdProject.setDescription(description);
		createdProject.setCreatedAt(LocalDateTime.now());
		
		try {
			projectService.createProject(createdProject);
			
			response.sendRedirect("../");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
