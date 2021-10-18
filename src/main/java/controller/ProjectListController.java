package controller;

import java.io.IOException;
import java.util.List;

import entity.Project;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.ProjectService;

@WebServlet(
	name = "projectList",
	urlPatterns = "/"
	)
public class ProjectListController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private final ProjectService projectService = new ProjectService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			List<Project> projects = projectService.findAll();
			RequestDispatcher dispatcher = request.getRequestDispatcher("projects.jsp");
			
			request.setAttribute("projects", projects);
			
			dispatcher.forward(request, response);
		} catch (Exception e) {
			System.err.println(e);
			System.out.println("error");
		}
	}

}
