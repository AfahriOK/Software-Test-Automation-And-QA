package task;

public class Task {

	private String taskID;
	private String name;
	private String description;
	
	//Constructor
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
	
	public String getTaskID() {
		return this.taskID;
	}
	
	public String getName() {
		return this.name;
	}
	
	void setName(String newName) {
		if(newName == null || newName.length() > 20) {
			throw new IllegalArgumentException("Invalid Name. Must set a name under 20 characters");
		}
		this.name = newName;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	void setDescription(String newDescription) {
		if (newDescription == null || newDescription.length() > 50) {
			throw new IllegalArgumentException("Invalid Description. Must set a description under 50 characters");
		}
		this.description = newDescription;
	}
}

