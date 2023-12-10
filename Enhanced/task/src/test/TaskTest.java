/**
 * @author Afahri Kerr (AfahriAKerr91@gmail.com)
 * @version 2.0
 * @since 12/07/2023
 * Purpose: Test that the Task class adheres to all requirements
 * Test Coverage: 100%
 * Project Requirements: 
 * 1. Must have a unique ID no longer than 10 characters and cannot be null (can not be updated)
 * 2. Must have a task name no longer than 20 characters and cannot be null (can be updated)
 * 3. Must have a description no longer than 50 characters and cannot be null (can be updated)
 */

package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import  org.junit.jupiter.api.Test;
import task.Task;

public class TaskTest {

	/**
	 * Test to make sure that a task can be created as long as all requirements are met
	 */
	@Test
	void testTaskClass() {
		Task task = new Task("2987487328", "Arbitrary task name.", "This is a 50 character long description of a task.");
		assertTrue(task.getTaskID().equals("2987487328"));
		assertTrue(task.getName().equals("Arbitrary task name."));
		assertTrue(task.getDescription().equals("This is a 50 character long description of a task."));
	}
	
	@Test
	void testTaskIDTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("29874873280", "Arbitrary task name.", "This is a 50 character long description of a task.");
		});
	}
	
	@Test
	void testTaskIDIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task(null, "Arbitrary task name.", "This is a 50 character long description of a task.");
		});
	}
	
	@Test
	void testNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("2987487328", "Arbitrary task name2.", "This is a 50 character long description of a task.");
		});
	}
	
	@Test
	void testNameIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("2987487328", null, "This is a 50 character long description of a task.");
		});
	}
	
	@Test
	void testDescriptionTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("2987487328", "Arbitrary task name.", "This is a 51 character long description of a task!.");
		});
	}
	
	@Test
	void testDescriptionIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("2987487328", "Arbitrary task name.", null);
		});
	}
	
}
