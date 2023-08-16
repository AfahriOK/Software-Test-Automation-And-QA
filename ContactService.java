package contact;

import java.util.ArrayList;

public class ContactService {

	private ArrayList<Contact> allContacts = new ArrayList<Contact>();
	
	private int findDuplicate(String ID) {
		int matchIndex = -1; 
		for (int i = 0; i < allContacts.size(); i++) {
			Contact currentContact = allContacts.get(i);
			if (currentContact.getContactID() == ID) {
				matchIndex = i;
				return matchIndex;
			}
		}
		return matchIndex;
	}
	
	public Contact getContact(String ID) {
		if (findDuplicate(ID) != -1) {
			Contact contact = allContacts.get(findDuplicate(ID));
			return contact;
		}
		throw new IllegalArgumentException("ID not found");
	}
	
	public void addContact(Contact contact) {
		if (findDuplicate(contact.getContactID()) == -1) {
		Contact newContact = contact;
		allContacts.add(newContact);
		} else {
			throw new IllegalArgumentException("ID is already taken");
		}
	}
	
	public void deleteContact(String ID) {
		if (findDuplicate(ID) == -1) {
			throw new IllegalArgumentException("ID not found");
		} else {
			allContacts.remove(findDuplicate(ID));
		}
	}
	
	public void updateFirstName(String ID, String newName) {
		if (findDuplicate(ID) == -1) {
			throw new IllegalArgumentException("ID not found");
		} else {
			Contact currentContact = allContacts.get(findDuplicate(ID));
			currentContact.setFirstName(newName);
		}
	}
		
	public void updateLastName(String ID, String newName) {
		if (findDuplicate(ID) == -1) {
			throw new IllegalArgumentException("ID not found");
		} else {
			Contact currentContact = allContacts.get(findDuplicate(ID));
			currentContact.setLastName(newName);
		}
	}
		
	public void updatePhoneNumber(String ID, String newPhoneNumber) {
		if (findDuplicate(ID) == -1) {
			throw new IllegalArgumentException("ID not found");
		} else {
			Contact currentContact = allContacts.get(findDuplicate(ID));
			currentContact.setPhone(newPhoneNumber);
		}
	}
	
	public void updateAddress(String ID, String newAddress) {
		if (findDuplicate(ID) == -1) {
			throw new IllegalArgumentException("ID not found");
		} else {
			Contact currentContact = allContacts.get(findDuplicate(ID));
			currentContact.setAddress(newAddress);
		}
	}
}

