/**
 * @author Afahri Kerr (AfahriAKerr91@gmail.com)
 * @version 2.0
 * @since 12/07/2023
 * Purpose: Create a service class to handle the task objects
 * Project Requirements: 
 * 1. Must have a unique ID no longer than 10 characters and cannot be null (can not be updated)
 * 2. Must have a task name no longer than 20 characters and cannot be null (can be updated)
 * 3. Must have a description no longer than 50 characters and cannot be null (can be updated)
 */

package task;

import java.util.HashMap;

/**
 * This class contains the logic to control the task objects
 */
public class TaskService {

	private HashMap<String, Task> allTasks = new HashMap<>();
	
	/**
	 * Method to get a specific task by ID
	 * @param ID Unique ID of task
	 * @return task
	 */
	public Task getTask(String ID) {
		if (allTasks.containsKey(ID)) {
			return allTasks.get(ID);
		} else {
			throw new IllegalArgumentException("ID not found");
		}
	}
	
	/**
	 * Method to add a task
	 * @param task task to be added 
	 */
	public void addTask(Task task) {
		if (!allTasks.containsKey(task.getTaskID())) {
		allTasks.put(task.getTaskID(), task);
		} else {
			throw new IllegalArgumentException("ID is already taken");
		}
	}
	
	/**
	 * Method to delete a task by ID
	 * @param ID Unique ID of task
	 */
	public void deleteTask(String ID) {
		if (allTasks.remove(ID) == null) {
			throw new IllegalArgumentException("ID not found");
		}
	}
	
	/**
	 * Method to update the name of a specific task
	 * @param ID Unique ID of task to be updated
	 * @param newName New name of task
	 */
	public void updateName(String ID, String newName) {
		if (!allTasks.containsKey(ID)) {
			throw new IllegalArgumentException("ID not found");
		} else {
			Task currentTask = allTasks.get(ID);
			currentTask.setName(newName);
		}
	}
		
	/**
	 * Method to update the description of a specific task
	 * @param ID Unique ID of task
	 * @param newDescription New description of task
	 */
	public void updateDescription(String ID, String newDescription) {
		if (!allTasks.containsKey(ID)) {
			throw new IllegalArgumentException("ID not found");
		} else {
			Task currentTask = allTasks.get(ID);
			currentTask.setDescription(newDescription);
		}
	}
}
