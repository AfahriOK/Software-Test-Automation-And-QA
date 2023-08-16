package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Assertions;
import  org.junit.jupiter.api.Test;
import appointment.Appointment;
import appointment.AppointmentService;

public class AppointmentServiceTest {

	@Test
	void testAddAppointment() {
		
		Date currentDate = new Date(System.currentTimeMillis());
		Date afterToday = new Date(currentDate.getTime() + 10);
		
		// Create new appointment service
		AppointmentService appointmentService = new AppointmentService();
		
		//Create new appointment
		Appointment newAppointment = new Appointment("1234567890", afterToday, "Is a 50 character description of some appointment.");
		
		// Add new appointment to built-in storage
		appointmentService.addAppointment(newAppointment);
		
		//retrieve newly added appointment
		Appointment appointment = appointmentService.getAppointment("1234567890");
		
		// Verify that all attributes are correct
		assertTrue(appointment.getAppointmentID().equals("1234567890"));
		assertTrue(appointment.getDate().compareTo(afterToday) == 0); // Gets the day of the month
		assertTrue(appointment.getDescription().equals("Is a 50 character description of some appointment."));
	}
	
	@Test
	void testAddAppointmentIsUnique() {
		
		Date currentDate = new Date(System.currentTimeMillis());
		Date afterToday = new Date(currentDate.getTime() + 10);
		
		// Create new appointment service
		AppointmentService appointmentService = new AppointmentService();
				
		//Create new appointment
		Appointment newAppointment = new Appointment("1234567890", afterToday, "Is a 50 character description of some appointment.");
				
		// Add new appointment to built-in storage
		appointmentService.addAppointment(newAppointment);
		
		//Create another appointment with same ID
		Appointment otherAppointment = new Appointment("1234567890", afterToday, "New appointment with same ID");
		
		//Will throw an error since ID already exists
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			appointmentService.addAppointment(otherAppointment);
		});
	}
	
	@Test
	void testDeleteAppointment() {
		
		Date currentDate = new Date(System.currentTimeMillis());
		Date afterToday = new Date(currentDate.getTime() + 10);
		
		// Create new appointment service
		AppointmentService appointmentService = new AppointmentService();
						
		//Create new appointment
		Appointment newAppointment = new Appointment("1234567890", afterToday, "Is a 50 character description of some appointment.");
						
		// Add new appointment to built-in storage
		appointmentService.addAppointment(newAppointment);
				
		//Delete the appointment
		appointmentService.deleteAppointment("1234567890");
		
		//Will throw error since appointment has been deleted
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			appointmentService.getAppointment("1234567890");
		});
	}
	
	@Test
	void testDeleteInvalidAppointment() {
		
		// Create new appointment service
		AppointmentService appointmentService = new AppointmentService();
				
		//Will throw error since there currently are not any appointments
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			appointmentService.deleteAppointment("1234567890");
		});
	}
	
}
