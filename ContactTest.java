package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import contact.Contact;

public class ContactTest {
	
	// Test to show that contact can be created as long as all rules are followed
	@Test
	void testContactClass() {
		Contact contact = new Contact("12039", "Afahri", "Kerr", "4042718140", "Atlanta, GA");
		assertTrue(contact.getContactID().equals("12039"));
		assertTrue(contact.getFirstName().equals("Afahri"));
		assertTrue(contact.getLastName().equals("Kerr"));
		assertTrue(contact.getPhone().equals("4042718140"));
		assertTrue(contact.getAddress().equals("Atlanta, GA"));
	}
	
	@Test
	void testContactIDTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345678901", "Afahri", "Kerr", "4042718140", "Atlanta, GA");
		});
	}
	
	@Test
	void testContactIDIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(null, "Afahri", "Kerr", "4042718140", "Atlanta, GA");
		});
	}
	
	@Test
	void testFirstNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12039", "ThisIsTooLong", "Kerr", "4042718140", "Atlanta, GA");
		});
	}
	
	@Test
	void testFirstNameIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12039", null, "Kerr", "4042718140", "Atlanta, GA");
		});
	}
	
	@Test
	void testLastNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12039", "Afahri", "ThisIsTooLong", "4042718140", "Atlanta, GA");
		});
	}
	
	@Test
	void testLastNameIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12039", "Afahri", null, "4042718140", "Atlanta, GA");
		});
	}
	
	@Test
	void testPhoneNumberTooShort() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12039", "Afahri", "Kerr", "404271814", "Atlanta, GA");
		});
	}
	
	@Test
	void testPhoneNumberTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12039", "Afahri", "Kerr", "40427181400", "Atlanta, GA");
		});
	}
	
	@Test
	void testPhoneNumberIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12039", "Afahri", "Kerr", null, "Atlanta, GA");
		});
	}
	
	@Test
	void testPhoneNumberIsNotDigit() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12039", "Afahri", "Kerr", "Is10Char28", "Atlanta, GA");
		});
	}
	
	@Test
	void testAddressTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12039", "Afahri", "Kerr", "4042718140", "ThisAddressIsWayTooLong, TooLong, USA");
		});
	}
	
	@Test
	void testAddressIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12039", "Afahri", "Kerr", "4042718140", null);
		});
	}
}
