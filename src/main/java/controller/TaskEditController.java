package controller;

import java.io.IOException;
import java.time.LocalDate;

import entity.Task;
import entity.TaskStatus;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.TaskService;

@WebServlet(
		name = "taskEdit",
		urlPatterns = "/task/edit"
		)

public class TaskEditController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private final TaskService taskService = new TaskService();
	Task task;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		try {
			Long id = Long.parseLong(request.getParameter("id"));	
			task = taskService.findTaskById(id);
			boolean isCompleted = task.getStatus() == TaskStatus.COMPLETED;
			request.setAttribute("task", task);
			request.setAttribute("completed", isCompleted);
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
		String date = request.getParameter("date");
		String status = request.getParameter("status");
			
		task.setName(name);
		task.setDescription(description);
		task.setDueDate(LocalDate.parse(date));
		
		if (status != null)
			task.setStatus(TaskStatus.COMPLETED);
		else
			task.setStatus(TaskStatus.ACTIVE);
		
		try {			
			taskService.updateTask(task);
			
			response.sendRedirect("../project/details?id=" + task.getProject().getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
