/**
 * @author Afahri Kerr (AfahriAKerr91@gmail.com)
 * @version 2.0
 * @since 12/07/2023
 * Purpose: Create a service class to handle the task objects
 * Test Coverage: 100%
 * Project Requirements: 
 * 1. Must have a unique ID no longer than 10 characters and cannot be null (can not be updated)
 * 2. Must have a task name no longer than 20 characters and cannot be null (can be updated)
 * 3. Must have a description no longer than 50 characters and cannot be null (can be updated)
 */

package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import  org.junit.jupiter.api.Test;
import task.Task;
import task.TaskService;

public class TaskServiceTest {
	
	private TaskService taskService;
	private Task newTask;
	
	/**
	 * Method to initialize the testing environment
	 */
	@BeforeEach
	void init() {
		// Create new task service
		taskService = new TaskService();
		
		// Create new task 
		newTask = new Task("2987487328", "Arbitrary task name.", "This is a 50 character long description of a task.");
		
		// Add new task to the built-in data storage
		taskService.addTask(newTask);
	}

	@Test
	void testAddTask() {
	
	// Retrieve new task from storage
	Task task = taskService.getTask("2987487328");
	
	assertTrue(task.getTaskID().equals("2987487328"));
	assertTrue(task.getName().equals("Arbitrary task name."));
	assertTrue(task.getDescription().equals("This is a 50 character long description of a task."));
	}
	
	@Test
	void testAddTaskIDIsUnique() {
		
		//Create task with same ID
		Task otherTask = new Task("2987487328", "Duplicate task name.", "This is a description of a different task.");
		
		// Try to add a new task with the same ID
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			taskService.addTask(otherTask);
		});
	}
	
	@Test
	void testDeleteTask() {
		
		// Delete task
		taskService.deleteTask("2987487328");
		
		// Will throw exception since task cannot be found after deletion
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			taskService.getTask("2987487328");
		});
	}
	
	@Test
	void testDeleteInvalidTask() {
				
		// Will throw exception since task ID is incorrect
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
		taskService.deleteTask("2987487329");
		});
	}
	
	@Test
	void testUpdateName() {
		
		//Update name to "New Task Name"
		taskService.updateName("2987487328", "New Task Name");
		
		//Retrieve task
		Task task = taskService.getTask("2987487328");
		
		// Make sure the name has changed
		assertTrue(task.getName().equals("New Task Name"));
	}
	
	@Test
	void testUpdateInvalidTask() {
				
		// Will throw exception since task ID is incorrect
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
		taskService.updateName("2987487329", "Arbitrary Task Name.");
		});
	}
	
	@Test
	void testUpdateNameToNull() {
		
		//Try to update name to null
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			taskService.updateName("2987487328", null);
		});
	}
	
	@Test
	void testUpdateNameTooLong() {
		
		//Try to update name
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			taskService.updateName("2987487328", "This task name is way too long");
		});
	}
	
	@Test
	void testUpdateDescription() {
				
		//Update description to "New Task Description"
		taskService.updateDescription("2987487328", "New Task Description");
				
		//Retrieve task
		Task task = taskService.getTask("2987487328");
				
		// Make sure the name has changed
		assertTrue(task.getDescription().equals("New Task Description"));
	}
	
	@Test
	void testUpdateDescriptionInvalidTask() {
				
		// Will throw exception since task ID is incorrect
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
		taskService.updateDescription("2987487329", "New Task Description");
		});
	}
	
	@Test
	void testUpdateDescriptionToNull() {
		
		//Try to update description to null
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			taskService.updateDescription("2987487328", null);
		});
	}
	
	@Test
	void testUpdateDescriptionTooLong() {
		
		//Try to update description
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			taskService.updateDescription("2987487328", "This is a 51 character long description of a task!.");
		});
	}
}

