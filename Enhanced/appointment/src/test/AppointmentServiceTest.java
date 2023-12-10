/**
 * @author Afahri Kerr (AfahriAKerr91@gmail.com)
 * @version 2.0
 * @since 12/07/2023
 * Purpose: Create a service class to handle the appointment objects
 * Test Coverage: 100%
 * Project Requirements: 
 * 1. Must have a unique ID no longer than 10 characters and cannot be null (can not be updated)
 * 2. Must have a date which is after the current date and cannot be null 
 * 3. Must have a description no longer than 50 characters and cannot be null 
 */

package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import  org.junit.jupiter.api.Test;
import appointment.Appointment;
import appointment.AppointmentService;

public class AppointmentServiceTest {
	
	private Date currentDate;
	private Date afterToday;
	private AppointmentService appointmentService;
	private Appointment newAppointment;
	
	/**
	 * Method to initialize the testing environment
	 */
	@BeforeEach
	// Sets up the initial appointment service and adds an appointment to it for testing
	void init() {
		currentDate = new Date(System.currentTimeMillis());
		afterToday = new Date(currentDate.getTime() + 10);
		
		// Create new appointment service
		appointmentService = new AppointmentService();
		
		// Create new appointment
		newAppointment = new Appointment("1234567890", afterToday, "Is a 50 character description of some appointment.");
		
		// Add new appointment to built-in storage
		appointmentService.addAppointment(newAppointment);
	}

	@Test
	void testAddAppointment() {

		// Retrieve newly added appointment
		Appointment appointment = appointmentService.getAppointment("1234567890");
		
		// Verify that all attributes are correct
		assertTrue(appointment.getAppointmentID().equals("1234567890"));
		assertTrue(appointment.getDate().compareTo(afterToday) == 0); // Gets the day of the month
		assertTrue(appointment.getDescription().equals("Is a 50 character description of some appointment."));
	}
	
	@Test
	void testAddAppointmentIsUnique() {
		
		// Create another appointment with same ID
		Appointment otherAppointment = new Appointment("1234567890", afterToday, "New appointment with same ID");
		
		// Will throw an error since ID already exists
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			appointmentService.addAppointment(otherAppointment);
		});
	}
	
	@Test
	void testDeleteAppointment() {
				
		// Delete the appointment
		appointmentService.deleteAppointment("1234567890");
		
		// Will throw error since appointment has been deleted
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			appointmentService.getAppointment("1234567890");
		});
	}
	
	@Test
	void testDeleteInvalidAppointment() {
				
		// Will throw error since appointment ID is incorrect
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			appointmentService.deleteAppointment("1234567800");
		});
	}
	
}
