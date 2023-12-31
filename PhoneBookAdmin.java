// defining a child class of the User class
public class PhoneBookAdmin extends User implements PhoneBookAdminInterface {
	
	// member variables
	
	private String emailAddress;
	
	// constructors
	
	// default constructor
	public PhoneBookAdmin() {
		
		// invokes no-arg constructor from parent class
		super();
		
		// default email address is empty string
		emailAddress = "";
	}
	
	// constructor that accepts passed username, password, and email address
	public PhoneBookAdmin(String username, String password, String emailAddress) {
		
		// invokes parent class constructor that accepts username and password
		super(username, password);
		this.emailAddress = emailAddress;
	}
	
	@Override
	public void PrintUserInfo() {
		
		System.out.println("Admin Info:");
		System.out.println("Username: " + username);
		System.out.println("Password: " + password);
		System.out.println("Email: " + emailAddress);
		System.out.println("Directory: ");
		userDirectory.printAllEntries();
	}
	
	// defining deleteUserEntrybyName method: deletes an entry that matches the passed first and last names by setting all attributes to default values
	public int deleteUserEntrybyName(String firstName, String lastName) {
		
		// calls SearchbyFirstNameLastName member method of PhoneBookDirectory class to find index of entry that matches passed name
		int index = userDirectory.SearchbyFirstNameLastName(firstName, lastName);
		
		// if entry is found
		if (index != -1) {
			
			// calls the getter method for the array containing the PhoneBookEntry objects
			// calls setter methods to set all attributes of specified entry to default values
			userDirectory.getDirectory()[index].setId(-1);
			userDirectory.getDirectory()[index].setFirstName("");
			userDirectory.getDirectory()[index].setLastName("");
			userDirectory.getDirectory()[index].setEmail("");
			userDirectory.getDirectory()[index].setZipCode(0);
			userDirectory.getDirectory()[index].setPhoneNumber("");
			
			// returns 0 if entry is found and deleted
			System.out.println("Entry deleted.\n");
			return 0;
		}
		
		else {
			
			// returns 1 if entry is not found
			System.out.println("No deletions made.\n");
			return 1;
		}
		
	}
	
	// defining binarySearchUserDirectory method
	public PhoneBookEntry binarySearchUserDirectory(int id) {
		
		// calls SearchbyIdBinarySearch member method from PhoneBookDirectory class
		PhoneBookEntry returnObj = userDirectory.SearchbyIdBinarySearch(id);
		
		return returnObj;
	}
	
	// defining changePassword method: takes String argument, sets new password value
	public void changePassword(String newPassword) {
		
		// calls setter method from parent class to access and alter the value of the password data field
		super.setPassword(newPassword);
		System.out.println("Password changed.\n");
	}
	
	// defining changeUsername method: takes String argument, sets new username value
	public void changeUsername(String newUsername) {
		
		// calls setter method from parent class to access and alter the value of the username data field
		super.setUsername(newUsername);
		System.out.println("Username changed.\n");
	}
}
