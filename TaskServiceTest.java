package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import  org.junit.jupiter.api.Test;
import task.Task;
import task.TaskService;

public class TaskServiceTest {

	@Test
	void testAddTask() {
	// Create new task service
	TaskService taskService = new TaskService();
	
	// Create new task 
	Task newTask = new Task("2987487328", "Arbitrary task name.", "This is a 50 character long description of a task.");
	
	// Add new task to the built-in data storage
	taskService.addTask(newTask);
	
	// Retrieve new task from storage
	Task task = taskService.getTask("2987487328");
	
	assertTrue(task.getTaskID().equals("2987487328"));
	assertTrue(task.getName().equals("Arbitrary task name."));
	assertTrue(task.getDescription().equals("This is a 50 character long description of a task."));
	}
	
	@Test
	void testAddTaskIDIsUnique() {
		// Create new task service
		TaskService taskService = new TaskService();
		
		// Create new task 
		Task newTask = new Task("2987487328", "Arbitrary task name.", "This is a 50 character long description of a task.");
				
		// Add new task to the built-in data storage
		taskService.addTask(newTask);
		
		//Create task with same ID
		Task otherTask = new Task("2987487328", "Duplicate task name.", "This is a description of a different task.");
		
		// Try to add a new task with the same ID
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			taskService.addTask(otherTask);
		});
	}
	
	@Test
	void testDeleteTask() {
		// Create new task service
		TaskService taskService = new TaskService();
				
		// Create new task 
		Task newTask = new Task("2987487328", "Arbitrary task name.", "This is a 50 character long description of a task.");
						
		// Add new task to the built-in data storage
		taskService.addTask(newTask);
		
		// Delete task
		taskService.deleteTask("2987487328");
		
		// Will throw exception since task cannot be found after deletion
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			taskService.getTask("2987487328");
		});
	}
	
	@Test
	void testDeleteInvalidTask() {
		// Create new task service
		TaskService taskService = new TaskService();
				
		// Will throw exception since task list is empty
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
		taskService.deleteTask("2987487328");
		});
	}
	
	@Test
	void testUpdateName() {
		// Create new task service
		TaskService taskService = new TaskService();
						
		// Create new task 
		Task newTask = new Task("2987487328", "Arbitrary task name.", "This is a 50 character long description of a task.");
								
		// Add new task to the built-in data storage
		taskService.addTask(newTask);
		
		//Update name to "New Task Name"
		taskService.updateName("2987487328", "New Task Name");
		
		//Retrieve task
		Task task = taskService.getTask("2987487328");
		
		// Make sure the name has changed
		assertTrue(task.getName().equals("New Task Name"));
	}
	
	@Test
	void testUpdateInvalidTask() {
		// Create new task service
		TaskService taskService = new TaskService();
				
		// Will throw exception since task list is empty
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
		taskService.updateName("2987487328", "Arbitrary Task Name.");
		});
	}
	
	@Test
	void testUpdateNameToNull() {
		// Create new task service
		TaskService taskService = new TaskService();
								
		// Create new task 
		Task newTask = new Task("2987487328", "Arbitrary task name.", "This is a 50 character long description of a task.");
										
		// Add new task to the built-in data storage
		taskService.addTask(newTask);
		
		//Try to update name to null
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			taskService.updateName("2987487328", null);
		});
	}
	
	@Test
	void testUpdateNameTooLong() {
		// Create new task service
		TaskService taskService = new TaskService();
								
		// Create new task 
		Task newTask = new Task("2987487328", "Arbitrary task name.", "This is a 50 character long description of a task.");
										
		// Add new task to the built-in data storage
		taskService.addTask(newTask);
		
		//Try to update name
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			taskService.updateName("2987487328", "This task name is way too long");
		});
	}
	
	@Test
	void testUpdateDescription() {
		// Create new task service
		TaskService taskService = new TaskService();
								
		// Create new task 
		Task newTask = new Task("2987487328", "Arbitrary task name.", "This is a 50 character long description of a task.");
									
		// Add new task to the built-in data storage
		taskService.addTask(newTask);
				
		//Update description to "New Task Description"
		taskService.updateDescription("2987487328", "New Task Description");
				
		//Retrieve task
		Task task = taskService.getTask("2987487328");
				
		// Make sure the name has changed
		assertTrue(task.getDescription().equals("New Task Description"));
	}
	
	@Test
	void testUpdateDescriptionInvalidTask() {
		// Create new task service
		TaskService taskService = new TaskService();
				
		// Will throw exception since task list is empty
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
		taskService.updateDescription("2987487328", "New Task Description");
		});
	}
	
	@Test
	void testUpdateDescriptionToNull() {
		// Create new task service
		TaskService taskService = new TaskService();
								
		// Create new task 
		Task newTask = new Task("2987487328", "Arbitrary task name.", "This is a 50 character long description of a task.");
										
		// Add new task to the built-in data storage
		taskService.addTask(newTask);
		
		//Try to update description to null
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			taskService.updateDescription("2987487328", null);
		});
	}
	
	@Test
	void testUpdateDescriptionTooLong() {
		// Create new task service
		TaskService taskService = new TaskService();
								
		// Create new task 
		Task newTask = new Task("2987487328", "Arbitrary task name.", "This is a 50 character long description of a task.");
										
		// Add new task to the built-in data storage
		taskService.addTask(newTask);
		
		//Try to update description
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			taskService.updateDescription("2987487328", "This is a 51 character long description of a task!.");
		});
	}
}

