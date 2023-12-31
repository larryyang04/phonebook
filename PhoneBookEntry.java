
public class PhoneBookEntry {
	
	// member variables
	
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private int zipCode;
	private String phoneNumber;
	
	// getters and setters
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getZipCode() {
		return zipCode;
	}
	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	// constructors
	
	// default constructor
	public PhoneBookEntry() {
		
		// default values: id = -1, all string data fields set as empty, zipcode set to 0
		id = -1;
		firstName = "";
		lastName = "";
		email = "";
		zipCode = 0;
		phoneNumber = "";
	}
	
	// constructor that takes all attributes
	public PhoneBookEntry(int id, String firstName, String lastName, String email, int zipCode, String phoneNumber) {
		
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.zipCode = zipCode;
		this.phoneNumber = phoneNumber;
		
	}
	
	// constructor that takes only first name and phone number
	public PhoneBookEntry (String firstName, String phoneNumber) {
		
		id = -1;
		this.firstName = firstName;
		lastName = "";
		email = "";
		zipCode = 0;
		this.phoneNumber = phoneNumber;
	}
	
	// constructor that takes only first name
	public PhoneBookEntry (String firstName) {
		
		id = -1;
		this.firstName = firstName;
		lastName = "";
		email = "";
		zipCode = 0;
		phoneNumber = "";
	}
	
	// defining printBookEntry method: prints all data fields
	public void printBookEntry() {
		
		System.out.println("---------- Info ----------");
		System.out.println("ID: " + id);
		System.out.println("First Name: " + firstName);
		System.out.println("Last Name: " + lastName);
		System.out.println("Email: " + email);
		System.out.println("Zip Code: " + zipCode);
		System.out.println("Phone Number: " + phoneNumber);
		System.out.println("--------------------------");
		System.out.println();
	}
	
}
