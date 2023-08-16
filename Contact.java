package contact;

public class Contact {
	
	private String contactID;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String address;
	
	// Constructor to set attributes
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
	
	// getters and setters
	public String getContactID() {
		return this.contactID;
	}
	
	public String getFirstName() {
		return this.firstName;
	}
	
	public void setFirstName(String newName) {
		if(newName == null || newName.length() > 10) {
			throw new IllegalArgumentException("Invalid First Name. Must set a name under 10 characters");
		}
		this.firstName = newName;
	}
	
	public String getLastName() {
		return this.lastName;
	}
	
	public void setLastName(String newName) {
		if(newName == null || newName.length() > 10) {
			throw new IllegalArgumentException("Invalid Last Name. Must set a name under 10 characters");
		}
		
		this.lastName = newName;
	}
	
	public String getPhone() {
		return this.phoneNumber;
	}
	
	public void setPhone(String newPhoneNumber) {
		if(newPhoneNumber == null || !newPhoneNumber.matches("\\d{10}")) {
			throw new IllegalArgumentException("Invalid Phone Number. Must set a phone number equal to 10 characters");
		}
		this.phoneNumber = newPhoneNumber;
	}
	
	public String getAddress() {
		return this.address;
	}
	
	public void setAddress(String newAddress) {
		if(newAddress == null || newAddress.length() > 30) {
			throw new IllegalArgumentException("Invalid Address. Must set an address under 30 characters");
		}
		this.address = newAddress;
	}
}