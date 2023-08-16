package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import appointment.Appointment;
import java.util.Date;

public class AppointmentTest {

	@Test
	void testAppointmentClass() {
		Date currentDate = new Date(System.currentTimeMillis());
		Date afterToday = new Date(currentDate.getTime() + 10);
		Appointment appointment = new Appointment("1234567890", afterToday, "Is a 50 character description of some appointment.");
		assertTrue(appointment.getAppointmentID().equals("1234567890"));
		assertTrue(appointment.getDate().compareTo(afterToday) == 0); //Gets the day of the month
		assertTrue(appointment.getDescription().equals("Is a 50 character description of some appointment."));
		System.out.println(appointment.getDate()); //Printing date to console to show it is correct
	}
	
	@Test
	void testAppointmentIDTooLong() {
		Date currentDate = new Date(System.currentTimeMillis());
		Date afterToday = new Date(currentDate.getTime() + 10);
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Appointment appointment = new Appointment("12345678901", afterToday, "Is a 50 character description of some appointment.");
		});
	}
	
	@Test
	void testAppointmentIDIsNull() {
		Date currentDate = new Date(System.currentTimeMillis());
		Date afterToday = new Date(currentDate.getTime() + 10);
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Appointment appointment = new Appointment(null, afterToday, "Is a 50 character description of some appointment.");
		});
	}
	
	@Test
	void testAppointmentDateInPast() {
		Date currentDate = new Date(System.currentTimeMillis());
		Date beforeToday = new Date(currentDate.getTime() - 1);
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Appointment appointment = new Appointment("1234567890", beforeToday, "Is a 50 character description of some appointment.");
		});
	}
	
	@Test
	void testAppointmentDescriptionTooLong() {
		Date currentDate = new Date(System.currentTimeMillis());
		Date afterToday = new Date(currentDate.getTime() + 10);
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Appointment appointment = new Appointment("1234567890", afterToday, "Is a 51 character description of some appointment!.");
		});
	}
	
	@Test
	void testAppointmentDescriptionIsNull() {
		Date currentDate = new Date(System.currentTimeMillis());
		Date afterToday = new Date(currentDate.getTime() + 10);
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Appointment appointment = new Appointment("1234567890", afterToday, null);
		});
	}
}
