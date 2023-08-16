package appointment;

import java.util.ArrayList;
import appointment.Appointment;

public class AppointmentService {

private ArrayList<Appointment> allAppointments = new ArrayList<Appointment>();
	
	private int findDuplicate(String ID) {
		int matchIndex = -1; 
		for (int i = 0; i < allAppointments.size(); i++) {
			Appointment currentAppointment = allAppointments.get(i);
			if (currentAppointment.getAppointmentID() == ID) {
				matchIndex = i;
				return matchIndex;
			}
		}
		return matchIndex;
	}
	
	public Appointment getAppointment(String ID) {
		if (findDuplicate(ID) != -1) {
			Appointment appointment = allAppointments.get(findDuplicate(ID));
			return appointment;
		}
		throw new IllegalArgumentException("ID not found");
	}
	
	public void addAppointment(Appointment appointment) {
		if (findDuplicate(appointment.getAppointmentID()) == -1) {
		Appointment newAppointment = appointment;
		allAppointments.add(newAppointment);
		} else {
			throw new IllegalArgumentException("ID is already taken");
		}
	}
	
	public void deleteAppointment(String ID) {
		if (findDuplicate(ID) == -1) {
			throw new IllegalArgumentException("ID not found");
		} else {
			allAppointments.remove(findDuplicate(ID));
		}
	}
	
}
