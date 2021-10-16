package service;

import dao.ProjectDao;
import entity.Project;

public class ProjectService {
	
	private ProjectDao projectDao;
	
	public ProjectService() {
		this.projectDao = new ProjectDao();
	}
	
	public void createProject(Project projectToSave) throws Exception {
		projectDao.create(projectToSave);
	}
	
	public void updateProject(Project projectToUpdate) throws Exception {
		projectDao.update(projectToUpdate);
	}
	
	public void deleteProject(Project projectToDelete) throws Exception {
		projectDao.delete(projectToDelete);
	}
	
	public Project findProjectById(Long id) throws Exception {
		return projectDao.getById(id);
	}
	
}
