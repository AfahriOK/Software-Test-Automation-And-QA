package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import  org.junit.jupiter.api.Test;
import contact.Contact;
import contact.ContactService;

public class ContactServiceTest {

	@Test
	void testAddContact() {
		// Create new contact service
		ContactService contactService = new ContactService();
		
		//Create new contact
		Contact newContact = new Contact("12039", "Afahri", "Kerr", "4042718140", "Atlanta, GA");
		
		// Add the new contact to built-in data storage
		contactService.addContact(newContact);
		
		// Retrieve newly created contact
		Contact contact = contactService.getContact("12039");
		
		// Verify that all new contact attributes are accurate
		assertTrue(contact.getContactID().equals("12039"));
		assertTrue(contact.getFirstName().equals("Afahri"));
		assertTrue(contact.getLastName().equals("Kerr"));
		assertTrue(contact.getPhone().equals("4042718140"));
		assertTrue(contact.getAddress().equals("Atlanta, GA"));
	}
	
	@Test
	void testAddContactIDIsUnique() {
		
		ContactService contactService = new ContactService();
		
		//Create new contact
		Contact newContact = new Contact("12039", "Afahri", "Kerr", "4042718140", "Atlanta, GA");
				
		// Add the new contact to built-in data storage
		contactService.addContact(newContact);
		
		//Create contact with same ID
		Contact otherContact = new Contact("12039", "This", "ContactID", "4042718140", "Is The Same");
		// Try to add a new contact with the same ID
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contactService.addContact(otherContact);
		});
	}
	
	@Test
	void testDeleteContact() {
		
		ContactService contactService = new ContactService();
		
		//Create new contact
		Contact newContact = new Contact("12039", "Afahri", "Kerr", "4042718140", "Atlanta, GA");
				
		// Add the new contact to built-in data storage
		contactService.addContact(newContact);
		
		// Delete the contact
		contactService.deleteContact("12039");
		
		// Will throw exception since contact can not be found after deletion
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contactService.getContact("12039");
		});
	}
	
	@Test
	void testDeleteInvalidContact() {
		
		ContactService contactService = new ContactService();
		
		// Will throw an exception since there currently aren't any contacts
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
		contactService.deleteContact("12039");
		});
	}
	
	@Test
	void testUpdateFirstName() {
		
		ContactService contactService = new ContactService();
		
		//Create new contact
		Contact newContact = new Contact("12039", "Afahri", "Kerr", "4042718140", "Atlanta, GA");
				
		// Add the new contact to built-in data storage
		contactService.addContact(newContact);
		
		// Change first name to New
		contactService.updateFirstName("12039", "New");
		
		// Retrieve contact
		Contact contact = contactService.getContact("12039");
		
		// Makes sure name has changed
		assertTrue(contact.getFirstName().equals("New"));
	}
	
	@Test
	void testUpdateFirstNameToNull() {
		
		ContactService contactService = new ContactService();
		
		//Create new contact
		Contact newContact = new Contact("12039", "Afahri", "Kerr", "4042718140", "Atlanta, GA");
				
		// Add the new contact to built-in data storage
		contactService.addContact(newContact);
		
		// Change first name to null
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
		contactService.updateFirstName("12039", null);
		});
	}
	
	@Test
	void testUpdateFirstNameTooLong() {
		
		ContactService contactService = new ContactService();
		
		//Create new contact
		Contact newContact = new Contact("12039", "Afahri", "Kerr", "4042718140", "Atlanta, GA");
				
		// Add the new contact to built-in data storage
		contactService.addContact(newContact);
		
		// Change first name
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
		contactService.updateFirstName("12039", "NameIsTooLong");
		});
	}
	
	@Test
	void testUpdateFirstNameInvalidContact() {
		
		ContactService contactService = new ContactService();
		
		// Will throw an exception since there currently aren't any contacts
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
		contactService.updateFirstName("12039", "New");
		});	
	}
	
	@Test
	void testUpdateLastName() {
		
		ContactService contactService = new ContactService();
		
		//Create new contact
		Contact newContact = new Contact("12039", "Afahri", "Kerr", "4042718140", "Atlanta, GA");
				
		// Add the new contact to built-in data storage
		contactService.addContact(newContact);
		
		// Change last name to New
		contactService.updateLastName("12039", "New");
		
		// Retrieve contact
		Contact contact = contactService.getContact("12039");
		
		// Makes sure name has changed
		assertTrue(contact.getLastName().equals("New"));
	}
	
	@Test
	void testUpdateLastNameToNull() {
		
		ContactService contactService = new ContactService();
		
		//Create new contact
		Contact newContact = new Contact("12039", "Afahri", "Kerr", "4042718140", "Atlanta, GA");
				
		// Add the new contact to built-in data storage
		contactService.addContact(newContact);
		
		// Change last name to null
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
		contactService.updateLastName("12039", null);
		});
	}
	
	@Test
	void testUpdateLastNameTooLong() {
		
		ContactService contactService = new ContactService();
		
		//Create new contact
		Contact newContact = new Contact("12039", "Afahri", "Kerr", "4042718140", "Atlanta, GA");
				
		// Add the new contact to built-in data storage
		contactService.addContact(newContact);
		
		// Change last name 
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
		contactService.updateLastName("12039", "LastNameTooLong");
		});
	}
	
	@Test
	void testUpdateLastNameInvalidContact() {
		
		ContactService contactService = new ContactService();
		
		// Will throw an exception since there currently aren't any contacts
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
		contactService.updateLastName("12039", "New");
		});	
	}
	
	@Test
	void testUpdatePhoneNumber() {
		
		ContactService contactService = new ContactService();
		
		//Create new contact
		Contact newContact = new Contact("12039", "Afahri", "Kerr", "4042718140", "Atlanta, GA");
				
		// Add the new contact to built-in data storage
		contactService.addContact(newContact);
		
		// Change phone number
		contactService.updatePhoneNumber("12039", "4702548756");
		
		// Retrieve contact
		Contact contact = contactService.getContact("12039");
		
		// Makes sure name has changed
		assertTrue(contact.getPhone().equals("4702548756"));
	}
	
	@Test
	void testUpdatePhoneNumberToNull() {
		
		ContactService contactService = new ContactService();
		
		//Create new contact
		Contact newContact = new Contact("12039", "Afahri", "Kerr", "4042718140", "Atlanta, GA");
				
		// Add the new contact to built-in data storage
		contactService.addContact(newContact);
		
		// Change phone number to null
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
		contactService.updatePhoneNumber("12039", null);
		});
	}
	
	@Test
	void testUpdatePhoneNumberTooLong() {
		
		ContactService contactService = new ContactService();
		
		//Create new contact
		Contact newContact = new Contact("12039", "Afahri", "Kerr", "4042718140", "Atlanta, GA");
				
		// Add the new contact to built-in data storage
		contactService.addContact(newContact);
		
		// Change phone number
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
		contactService.updatePhoneNumber("12039", "40427181401");
		});
	}
	
	@Test
	void testUpdatePhoneNumberNotDigit() {
		
		ContactService contactService = new ContactService();
		
		//Create new contact
		Contact newContact = new Contact("12039", "Afahri", "Kerr", "4042718140", "Atlanta, GA");
				
		// Add the new contact to built-in data storage
		contactService.addContact(newContact);
		
		// Change phone number not digits
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
		contactService.updatePhoneNumber("12039", "what1sthis");
		});
	}
	
	@Test
	void testUpdatePhoneNumberInvalidContact() {
		
		ContactService contactService = new ContactService();
		
		// Will throw an exception since there currently aren't any contacts
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
		contactService.updatePhoneNumber("12039", "4702548756");
		});	
	}
	
	@Test
	void testUpdateAddress() {
		
		ContactService contactService = new ContactService();
		
		//Create new contact
		Contact newContact = new Contact("12039", "Afahri", "Kerr", "4042718140", "Atlanta, GA");
				
		// Add the new contact to built-in data storage
		contactService.addContact(newContact);
		
		// Change Address
		contactService.updateAddress("12039", "New Address");
		
		// Retrieve contact
		Contact contact = contactService.getContact("12039");
		
		// Makes sure name has changed
		assertTrue(contact.getAddress().equals("New Address"));
	}
	
	@Test
	void testUpdateAddressToNull() {
		
		ContactService contactService = new ContactService();
		
		//Create new contact
		Contact newContact = new Contact("12039", "Afahri", "Kerr", "4042718140", "Atlanta, GA");
				
		// Add the new contact to built-in data storage
		contactService.addContact(newContact);
		
		// Change address to null
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
		contactService.updateAddress("12039", null);
		});
	}
	@Test
	void testUpdateAddressInvalidContact() {
		
		ContactService contactService = new ContactService();
		
		// Will throw an exception since there currently aren't any contacts
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
		contactService.updateAddress("12039", "New Address");
		});	
	}
}
