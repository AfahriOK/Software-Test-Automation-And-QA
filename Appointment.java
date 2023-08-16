package appointment;

import java.util.Date;

public class Appointment {

	private String appointmentID;
	private Date date;
	private String description;
	
	public Appointment(String ID, Date date, String description) {
		
		if(ID == null || ID.length() > 10) {
			throw new IllegalArgumentException("Invalid ID. Must set a unique ID under 10 characters");
		}
		
		if (date == null || date.before(new Date())) {
			throw new IllegalArgumentException("Invalid date. Must set a date in the future");
		}
		
		if (description == null || description.length() > 50) {
			throw new IllegalArgumentException("Invalid description. Must set a description under 50 characters");
		}
		
		this.appointmentID = ID;
		this.date = date;
		this.description = description;
	}
	
	public String getAppointmentID() {
		return this.appointmentID;
	}
	
	public Date getDate() {
		return this.date;
	}
	
	public String getDescription() {
		return this.description;
	}
}
