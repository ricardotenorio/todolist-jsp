package controller;

import java.io.IOException;

import entity.Project;
import entity.Task;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.ProjectService;
import service.TaskService;

@WebServlet(
		name = "projectDetails",
		urlPatterns = "/project/details"
		)
public class ProjectDetailsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final ProjectService projectService = new ProjectService();
	private final TaskService taskService = new TaskService();
	Project project;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		try {
			Long id = Long.parseLong(request.getParameter("id"));	
			project = projectService.findProjectById(id);
			updateTaskStatus();
			request.setAttribute("project", project);
		} catch (Exception e) {	
			e.printStackTrace();
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("details.jsp");
		
		dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String description = request.getParameter("description");
			
		project.setName(name);
		project.setDescription(description);
		
		try {
			projectService.updateProject(project);
			
			response.sendRedirect("../");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private void updateTaskStatus() throws Exception {
		for (Task task : project.getTasks()) {
			taskService.updateStatus(task);
		}
	}

}