/**
 * @author Afahri Kerr (AfahriAKerr91@gmail.com)
 * @version 2.0
 * @since 12/07/2023
 * Purpose: Create an object to store a contacts appointment information
 * Test Coverage: 100%
 * Project Requirements: 
 * 1. Must have a unique ID no longer than 10 characters and cannot be null (can not be updated)
 * 2. Must have a date which is after the current date and cannot be null 
 * 3. Must have a description no longer than 50 characters and cannot be null 
 */

package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import appointment.Appointment;
import java.util.Date;

public class AppointmentTest {
	
	private Date currentDate;
	private Date afterToday;
	private Date beforeToday;
	
	/**
	 * Method to initialize the testing environment
	 */
	@BeforeEach
	void init() {
		currentDate = new Date(System.currentTimeMillis());
		afterToday = new Date(currentDate.getTime() + 10);
		beforeToday = new Date(currentDate.getTime() - 1);
	}
	
	@Test
	void testAppointmentClass() {
		Appointment appointment = new Appointment("1234567890", afterToday, "Is a 50 character description of some appointment.");
		assertTrue(appointment.getAppointmentID().equals("1234567890"));
		assertTrue(appointment.getDate().compareTo(afterToday) == 0); //Gets the day of the month
		assertTrue(appointment.getDescription().equals("Is a 50 character description of some appointment."));
		System.out.println(appointment.getDate()); //Printing date to console to show it is correct
	}
	
	@Test
	void testAppointmentIDTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			@SuppressWarnings("unused")
			Appointment appointment = new Appointment("12345678901", afterToday, "Is a 50 character description of some appointment.");
		});
	}
	
	@Test
	void testAppointmentIDIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			@SuppressWarnings("unused")
			Appointment appointment = new Appointment(null, afterToday, "Is a 50 character description of some appointment.");
		});
	}
	
	@Test
	void testAppointmentDateInPast() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			@SuppressWarnings("unused")
			Appointment appointment = new Appointment("1234567890", beforeToday, "Is a 50 character description of some appointment.");
		});
	}
	
	@Test
	void testAppointmentDescriptionTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			@SuppressWarnings("unused")
			Appointment appointment = new Appointment("1234567890", afterToday, "Is a 51 character description of some appointment!.");
		});
	}
	
	@Test
	void testAppointmentDescriptionIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			@SuppressWarnings("unused")
			Appointment appointment = new Appointment("1234567890", afterToday, null);
		});
	}
}
