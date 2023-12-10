/**
 * @author Afahri Kerr (AfahriAKerr91@gmail.com)
 * @version 2.0
 * @since 12/07/2023
 * Purpose: Create a service class to handle the appointment objects
 * Project Requirements: 
 * 1. Must have a unique ID no longer than 10 characters and cannot be null (can not be updated)
 * 2. Must have a date which is after the current date and cannot be null 
 * 3. Must have a description no longer than 50 characters and cannot be null 
 */

package appointment;

import java.util.HashMap;

/**
 * This class contains the logic to control the Appointment objects
 */
public class AppointmentService {

	private HashMap<String, Appointment> allAppointments = new HashMap<>();
	
	/**
	 * Method to get a specific appointment by ID
	 * @param ID Unique ID of appointment
	 * @return appointment
	 */
	public Appointment getAppointment(String ID) {
		if (allAppointments.containsKey(ID)) {
			return allAppointments.get(ID);
		} else {
		throw new IllegalArgumentException("ID not found");
		}
	}
	
	/**
	 * Method to add an appointment
	 * @param appointment Appointment to be added
	 */
	public void addAppointment(Appointment appointment) {
		if (!allAppointments.containsKey(appointment.getAppointmentID())) {
		allAppointments.put(appointment.getAppointmentID(), appointment);
		} else {
			throw new IllegalArgumentException("ID is already taken");
		}
	}
	
	/**
	 * Method to delete a specific appointment by ID
	 * @param ID Unique ID of appointment
	 */
	public void deleteAppointment(String ID) {
		if (allAppointments.remove(ID) == null) {
			throw new IllegalArgumentException("ID not found");
		}
	}
}
