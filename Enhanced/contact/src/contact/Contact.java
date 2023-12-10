/**
 * @author Afahri Kerr (AfahriAKerr91@gmail.com)
 * @version 2.0
 * @since 12/07/2023
 * Purpose: Create an object to store customer information
 * Project Requirements: 
 * 1. Must have a unique ID no longer than 10 characters and cannot be null (can not be updated)
 * 2. Must have a first and last name no longer than 10 characters and cannot be null (can be updated)
 * 3. Must have a phone number which is a valid 10 digit number and cannot be null (can be updated)
 * 4. Must have an address no longer than 30 characters and cannot be null (can be updated)
 */

package contact;

/**
 * This class is used to create a Contact object to store customer information such as an ID, name, phone number, and address
 */
public class Contact {
	
	private String contactID;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String address;
	
	/**
	 * Constructor to create the Contact object
	 * @param ID Unique ID of the contact
	 * @param firstName Contact first name
	 * @param lastName Contact last name
	 * @param phoneNumber Contact phone number
	 * @param address Contact address
	 */
	public Contact(String ID, String firstName, String lastName, String phoneNumber, String address) {
		
		if(ID == null || ID.length() > 10) {
			throw new IllegalArgumentException("Invalid ID. Must set a unique ID under 10 characters");
		}
		
		if(firstName == null || firstName.length() > 10) {
			throw new IllegalArgumentException("Invalid First Name. Must set a name under 10 characters");
		}
		
		if(lastName == null || lastName.length() > 10) {
			throw new IllegalArgumentException("Invalid Last Name. Must set a name under 10 characters");
		}
		
		if(phoneNumber == null || !phoneNumber.matches("\\d{10}")) {
			throw new IllegalArgumentException("Invalid Phone Number. Must set a phone number equal to 10 digits");
		}
		
		if(address == null || address.length() > 30) {
			throw new IllegalArgumentException("Invalid Address. Must set an address under 30 characters");
		}
		
		this.contactID = ID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}
	
	/**
	 * Method to return the Contacts ID
	 * @return contact ID
	 */
	public String getContactID() {
		return this.contactID;
	}
	
	/**
	 * Method to return the contacts first name
	 * @return contacts first name
	 */
	public String getFirstName() {
		return this.firstName;
	}
	
	/**
	 * Method allows you to set a first name for the contact
	 * @param newName First name of contact
	 */
	public void setFirstName(String newName) {
		if(newName == null || newName.length() > 10) {
			throw new IllegalArgumentException("Invalid First Name. Must set a name under 10 characters");
		}
		this.firstName = newName;
	}
	
	/**
	 * Method to return the contacts last name
	 * @return contacts last name
	 */
	public String getLastName() {
		return this.lastName;
	}
	
	/**
	 * Method allows you to set a last name for the contact
	 * @param newName last name of contact
	 */
	public void setLastName(String newName) {
		if(newName == null || newName.length() > 10) {
			throw new IllegalArgumentException("Invalid Last Name. Must set a name under 10 characters");
		}
		
		this.lastName = newName;
	}
	
	/**
	 * Method to return the contacts phone number
	 * @return contacts phone number
	 */
	public String getPhone() {
		return this.phoneNumber;
	}
	
	/**
	 * Method allows you to set a phone number for the contact
	 * @param newPhoneNumber Phone number of contact
	 */
	public void setPhone(String newPhoneNumber) {
		if(newPhoneNumber == null || !newPhoneNumber.matches("\\d{10}")) {
			throw new IllegalArgumentException("Invalid Phone Number. Must set a phone number equal to 10 characters");
		}
		this.phoneNumber = newPhoneNumber;
	}
	
	/**
	 * Method to return the contacts address
	 * @return contacts address
	 */
	public String getAddress() {
		return this.address;
	}
	
	/**
	 * Method allows you to set an address for the contact
	 * @param newAddress Address of contact
	 */
	public void setAddress(String newAddress) {
		if(newAddress == null || newAddress.length() > 30) {
			throw new IllegalArgumentException("Invalid Address. Must set an address under 30 characters");
		}
		this.address = newAddress;
	}
}