package service;

import java.time.LocalDate;

import dao.TaskDao;
import entity.Task;
import entity.TaskStatus;

public class TaskService {

	private TaskDao taskDao;
	
	public TaskService() {
		taskDao = new TaskDao();
	}
	
	public void createTask(Task taskToSave) throws Exception {
		taskDao.create(taskToSave);
	}
	
	public void updateTask(Task taskToUpdate) throws Exception {
		taskDao.update(taskToUpdate);
	}
	
	public void deleteTask(Task taskToDelete) throws Exception {
		taskDao.delete(taskToDelete);
	}
	
	public Task findTaskById(Long id) throws Exception {
		return taskDao.getById(id);
	}
	
	public Task updateStatus(Task task) throws Exception {
		if (task.getStatus().equals(TaskStatus.COMPLETED)) {
			return task;
		}
		
		if (LocalDate.now().isAfter(task.getDueDate())) {
			task.setStatus(TaskStatus.OVERDUE);
			updateTask(task);
		}
		
		return task;
	}
	
}
