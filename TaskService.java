package task;

import java.util.ArrayList;

public class TaskService {

	private ArrayList<Task> allTasks = new ArrayList<Task>();
	
	private int findDuplicate(String ID) {
		int matchIndex = -1; 
		for (int i = 0; i < allTasks.size(); i++) {
			Task currentTask = allTasks.get(i);
			if (currentTask.getTaskID() == ID) {
				matchIndex = i;
				return matchIndex;
			}
		}
		return matchIndex;
	}
	
	public Task getTask(String ID) {
		if (findDuplicate(ID) != -1) {
			Task task = allTasks.get(findDuplicate(ID));
			return task;
		}
		throw new IllegalArgumentException("ID not found");
	}
	
	public void addTask(Task task) {
		if (findDuplicate(task.getTaskID()) == -1) {
		Task newTask = task;
		allTasks.add(newTask);
		} else {
			throw new IllegalArgumentException("ID is already taken");
		}
	}
	
	public void deleteTask(String ID) {
		if (findDuplicate(ID) == -1) {
			throw new IllegalArgumentException("ID not found");
		} else {
			allTasks.remove(findDuplicate(ID));
		}
	}
	
	public void updateName(String ID, String newName) {
		if (findDuplicate(ID) == -1) {
			throw new IllegalArgumentException("ID not found");
		} else {
			Task currentTask = allTasks.get(findDuplicate(ID));
			currentTask.setName(newName);
		}
	}
		
	public void updateDescription(String ID, String newDescription) {
		if (findDuplicate(ID) == -1) {
			throw new IllegalArgumentException("ID not found");
		} else {
			Task currentTask = allTasks.get(findDuplicate(ID));
			currentTask.setDescription(newDescription);
		}
	}
}
