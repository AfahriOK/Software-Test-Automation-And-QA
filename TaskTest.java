package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import  org.junit.jupiter.api.Test;
import task.Task;

public class TaskTest {

	//Test that task can be made as long as rules are followed
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
