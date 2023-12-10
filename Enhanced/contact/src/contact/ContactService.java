/**
 * @author Afahri Kerr (AfahriAKerr91@gmail.com)
 * @version 2.0
 * @since 12/07/2023
 * Purpose: Create a service class to handle the contact objects
 * Project Requirements: 
 * 1. Must have a unique ID no longer than 10 characters and cannot be null (can not be updated)
 * 2. Must have a first and last name no longer than 10 characters and cannot be null (can be updated)
 * 3. Must have a phone number which is a valid 10 digit number and cannot be null (can be updated)
 * 4. Must have an address no longer than 30 characters and cannot be null (can be updated)
 */

package contact;

import java.util.HashMap;

/**
 *This class contains the logic to control the contact objects
 */
public class ContactService {

	private HashMap<String, Contact> allContacts = new HashMap<>();
	
	/**
	 * Method to return an individual contact
	 * @param ID Unique ID of the desired contact
	 * @return Contact if ID found
	 */
	public Contact getContact(String ID) {
		if (allContacts.containsKey(ID)) {
			return allContacts.get(ID);
		} else {
		throw new IllegalArgumentException("ID not found");
		}
	}
	
	/**
	 * Method to add a contact
	 * @param contact to be added
	 */
	public void addContact(Contact contact) {
		if (!allContacts.containsKey(contact.getContactID())) {
		allContacts.put(contact.getContactID(), contact);
		} else {
			throw new IllegalArgumentException("ID is already taken");
		}
	}
	
	/**
	 * Method to delete a specific Contact
	 * @param ID ID of contact to be deleted
	 */
	public void deleteContact(String ID) {
		if (allContacts.remove(ID) == null) {
			throw new IllegalArgumentException("ID not found");
		} 
	}
	
	/**
	 * Method to update a specific contacts first name
	 * @param ID Unique ID of contact to be updated
	 * @param newName New first name
	 */
	public void updateFirstName(String ID, String newName) {
		if (!allContacts.containsKey(ID)) {
			throw new IllegalArgumentException("ID not found");
		} else {
			Contact currentContact = allContacts.get(ID);
			currentContact.setFirstName(newName);
		}
	}
		
	/**
	 * Method to update a specific contacts last name
	 * @param ID Unique ID of contact to be updated
	 * @param newName New last name
	 */
	public void updateLastName(String ID, String newName) {
		if (!allContacts.containsKey(ID)) {
			throw new IllegalArgumentException("ID not found");
		} else {
			Contact currentContact = allContacts.get(ID);
			currentContact.setLastName(newName);
		}
	}
		
	/**
	 * Method to update a specific contacts phone number
	 * @param ID Unique ID of contact to be updated
	 * @param newPhoneNumber New phone number
	 */
	public void updatePhoneNumber(String ID, String newPhoneNumber) {
		if (!allContacts.containsKey(ID)) {
			throw new IllegalArgumentException("ID not found");
		} else {
			Contact currentContact = allContacts.get(ID);
			currentContact.setPhone(newPhoneNumber);
		}
	}
	
	/**
	 * Method to update the address of a specific contact
	 * @param ID Unique ID of contact to be updated
	 * @param newAddress New address
	 */
	public void updateAddress(String ID, String newAddress) {
		if (!allContacts.containsKey(ID)) {
			throw new IllegalArgumentException("ID not found");
		} else {
			Contact currentContact = allContacts.get(ID);
			currentContact.setAddress(newAddress);
		}
	}
}

