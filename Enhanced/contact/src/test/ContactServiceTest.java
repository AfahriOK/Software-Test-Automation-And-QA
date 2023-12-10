/**
 * @author Afahri Kerr (AfahriAKerr91@gmail.com)
 * @version 2.0
 * @since 12/07/2023
 * Purpose: Test that the Contact service class functions as intended
 * Test Coverage: 100%
 * Project Requirements: 
 * 1. Must have a unique ID no longer than 10 characters and cannot be null (can not be updated)
 * 2. Must have a first and last name no longer than 10 characters and cannot be null (can be updated)
 * 3. Must have a phone number which is a valid 10 digit number and cannot be null (can be updated)
 * 4. Must have an address no longer than 30 characters and cannot be null  (can be updated)
 */

package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import  org.junit.jupiter.api.Test;
import contact.Contact;
import contact.ContactService;

public class ContactServiceTest {
	
	private ContactService contactService;
	private Contact newContact;

	/**
	 * Method to initialize the contact service and add a contact to it.
	 */
	@BeforeEach
	void init() {
		// Create new contact service
		contactService = new ContactService();
				
		//Create new contact
		newContact = new Contact("12039", "Afahri", "Kerr", "4042718140", "Atlanta, GA");
				
		// Add the new contact to built-in data storage
		contactService.addContact(newContact);
	}
	
	@Test
	void testAddContact() {
		
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
		
		//Create contact with same ID
		Contact otherContact = new Contact("12039", "This", "ContactID", "4042718140", "Is The Same");
		// Try to add a new contact with the same ID
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contactService.addContact(otherContact);
		});
	}
	
	@Test
	void testDeleteContact() {
		
		// Delete the contact
		contactService.deleteContact("12039");
		
		// Will throw exception since contact can not be found after deletion
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contactService.getContact("12039");
		});
	}
	
	@Test
	void testDeleteInvalidContact() {
		
		// Will throw an exception since there currently aren't any contacts with that ID
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
		contactService.deleteContact("12049");
		});
	}
	
	@Test
	void testUpdateFirstName() {
		
		// Change first name to New
		contactService.updateFirstName("12039", "New");
		
		// Retrieve contact
		Contact contact = contactService.getContact("12039");
		
		// Makes sure name has changed
		assertTrue(contact.getFirstName().equals("New"));
	}
	
	@Test
	void testUpdateFirstNameToNull() {
		
		// Change first name to null
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
		contactService.updateFirstName("12039", null);
		});
	}
	
	@Test
	void testUpdateFirstNameTooLong() {
		
		// Change first name
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
		contactService.updateFirstName("12039", "NameIsTooLong");
		});
	}
	
	@Test
	void testUpdateFirstNameInvalidContact() {
		
		// Will throw an exception since there currently aren't any contacts with that ID number
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
		contactService.updateFirstName("12049", "New");
		});	
	}
	
	@Test
	void testUpdateLastName() {
		
		// Change last name to New
		contactService.updateLastName("12039", "New");
		
		// Retrieve contact
		Contact contact = contactService.getContact("12039");
		
		// Makes sure name has changed
		assertTrue(contact.getLastName().equals("New"));
	}
	
	@Test
	void testUpdateLastNameToNull() {
		
		// Change last name to null
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
		contactService.updateLastName("12039", null);
		});
	}
	
	@Test
	void testUpdateLastNameTooLong() {
		
		// Change last name 
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
		contactService.updateLastName("12039", "LastNameTooLong");
		});
	}
	
	@Test
	void testUpdateLastNameInvalidContact() {
		
		// Will throw an exception since there currently aren't any contacts with that ID number
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
		contactService.updateLastName("12049", "New");
		});	
	}
	
	@Test
	void testUpdatePhoneNumber() {
		
		// Change phone number
		contactService.updatePhoneNumber("12039", "4702548756");
		
		// Retrieve contact
		Contact contact = contactService.getContact("12039");
		
		// Makes sure name has changed
		assertTrue(contact.getPhone().equals("4702548756"));
	}
	
	@Test
	void testUpdatePhoneNumberToNull() {
		
		// Change phone number to null
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
		contactService.updatePhoneNumber("12039", null);
		});
	}
	
	@Test
	void testUpdatePhoneNumberTooLong() {
		
		// Change phone number
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
		contactService.updatePhoneNumber("12039", "40427181401");
		});
	}
	
	@Test
	void testUpdatePhoneNumberNotDigit() {
		
		// Change phone number not digits
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
		contactService.updatePhoneNumber("12039", "what1sthis");
		});
	}
	
	@Test
	void testUpdatePhoneNumberInvalidContact() {
		
		// Will throw an exception since there currently aren't any contacts with that ID number
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
		contactService.updatePhoneNumber("12049", "4702548756");
		});	
	}
	
	@Test
	void testUpdateAddress() {
		
		// Change Address
		contactService.updateAddress("12039", "New Address");
		
		// Retrieve contact
		Contact contact = contactService.getContact("12039");
		
		// Makes sure name has changed
		assertTrue(contact.getAddress().equals("New Address"));
	}
	
	@Test
	void testUpdateAddressToNull() {
		
		// Change address to null
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
		contactService.updateAddress("12039", null);
		});
	}
	
	@Test
	void testUpdateAddressInvalidContact() {
		
		// Will throw an exception since there currently aren't any contacts with that ID number
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
		contactService.updateAddress("12049", "New Address");
		});	
	}
}
