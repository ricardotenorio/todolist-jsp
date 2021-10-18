package controller;

import java.io.IOException;
import java.time.LocalDateTime;

import org.hibernate.type.LocalDateType;

import entity.Project;
import entity.Task;
import entity.TaskStatus;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.ProjectService;
import service.TaskService;

@WebServlet(
		name = "taskCreate",
		urlPatterns = "/task/create"
		)
public class TaskCreateController {

	private static final long serialVersionUID = 1L;
	private final ProjectService projectService = new ProjectService();
	private final TaskService taskService = new TaskService();
	Task task;
	Project project;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		try {
			Long id = Long.parseLong(request.getParameter("id"));	
			project = projectService.findProjectById(id);
			request.setAttribute("project", project);
		} catch (Exception e) {	
			e.printStackTrace();
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("create.jsp");
		
		dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		String date = request.getParameter("date");
			
		Task createdTask = new Task();
		createdTask.setName(name);
		createdTask.setDescription(description);
		createdTask.setDueDate(LocalDateTime.parse(date));
		createdTask.setCreatedAt(LocalDateTime.now());
		createdTask.setStatus(TaskStatus.ACTIVE);
		createdTask.setProject(project);
		
		try {
			taskService.createTask(createdTask);
			
			response.sendRedirect("../project/details");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
