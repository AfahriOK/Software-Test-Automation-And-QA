/**
 * @author Afahri Kerr (AfahriAKerr91@gmail.com)
 * @version 2.0
 * @since 12/07/2023
 * Purpose: Create an object to store a contacts task information
 * Project Requirements: 
 * 1. Must have a unique ID no longer than 10 characters and cannot be null (can not be updated)
 * 2. Must have a task name no longer than 20 characters and cannot be null (can be updated)
 * 3. Must have a description no longer than 50 characters and cannot be null (can be updated)
 */

package task;

/**
 *This class us used to create a Task object to store the task ID, name, and description
 */
public class Task {

	private String taskID;
	private String name;
	private String description;
	
	/**
	 * Constructor to create the Task object
	 * @param ID Unique ID of the task
	 * @param name Task name
	 * @param description Task description
	 */
	public Task(String ID, String name, String description) {
		
		if (ID == null || ID.length() > 10) {
			throw new IllegalArgumentException("Invalid ID. Must set a unique ID under 10 characters");
		}
		
		if (name == null || name.length() > 20) {
			throw new IllegalArgumentException("Invalid Name. Must set a name under 20 characters");
		}
		
		if (description == null || description.length() > 50) {
			throw new IllegalArgumentException("Invalid Description. Must set a description under 50 characters");
		}
		
		this.taskID = ID;
		this.name = name;
		this.description = description;
	}
	
	/**
	 * Method to return the task ID
	 * @return task ID
	 */
	public String getTaskID() {
		return this.taskID;
	}
	
	/**
	 * Method to return the task name
	 * @return task name
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Method to set the task name
	 * @param newName New task name
	 */
	void setName(String newName) {
		if(newName == null || newName.length() > 20) {
			throw new IllegalArgumentException("Invalid Name. Must set a name under 20 characters");
		}
		this.name = newName;
	}
	
	/**
	 * Method to get a task description
	 * @return task description
	 */
	public String getDescription() {
		return this.description;
	}
	
	/**
	 * Method to set the task description
	 * @param newDescription New task description
	 */
	void setDescription(String newDescription) {
		if (newDescription == null || newDescription.length() > 50) {
			throw new IllegalArgumentException("Invalid Description. Must set a description under 50 characters");
		}
		this.description = newDescription;
	}
}

