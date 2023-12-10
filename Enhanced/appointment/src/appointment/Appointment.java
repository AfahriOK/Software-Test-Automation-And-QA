/**
 * @author Afahri Kerr (AfahriAKerr91@gmail.com)
 * @version 2.0
 * @since 12/07/2023
 * Purpose: Create an object to store a contacts appointment information
 * Project Requirements: 
 * 1. Must have a unique ID no longer than 10 characters and cannot be null (can not be updated)
 * 2. Must have a date which is after the current date and cannot be null 
 * 3. Must have a description no longer than 50 characters and cannot be null 
 */

package appointment;

import java.util.Date;

/**
 * This class is used to create an Appointment object to store the appointments ID, date, and description
 */
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
	
	/**
	 * Method to get the appointments ID
	 * @return appointment ID
	 */
	public String getAppointmentID() {
		return this.appointmentID;
	}
	
	/**
	 * Method to get the appointments date
	 * @return appointment date
	 */
	public Date getDate() {
		return this.date;
	}
	
	/**
	 * Method to get the appointments description
	 * @return appointment description
	 */
	public String getDescription() {
		return this.description;
	}
}
