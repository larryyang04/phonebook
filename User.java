// defining the parent class
public class User {

	// member variables
	
	// protected modifer so child classes can inherit member variables, but user cannot access without public getters/setters
	protected String username;
	protected String password;
	protected PhoneBookDirectory userDirectory;
	
	// getters and setters
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	// constructors
	
	// default no-arg constructor
	public User() {
		
		// default username and password are empty strings
		username = "";
		password = "";
		
		// creating default PhoneBookDirectory object by calling default constructor of PhoneBookDirectory class
		userDirectory = new PhoneBookDirectory();
	}
	
	// constructor that takes username and password as arguments
	public User(String username, String password) {
		
		this.username = username;
		this.password = password;
		userDirectory = new PhoneBookDirectory();
	}
	
	// defining PrintUserInfo method: prints username and password attributes to screen
	public void PrintUserInfo() {
		
		System.out.println("User Info:");
		System.out.println("Username: " + username);
		System.out.println("Password: " + password);
		System.out.println();
	}
	
	// defining addUserEntry method
	public int addUserEntry(PhoneBookEntry entry) {
		
		// calls addEntry member method from PhoneBookDirectory class
		int i = userDirectory.addEntry(entry);
		return i;
	}
	
	// defining editUserEntry method
	public int editUserEntry(String firstName, String lastName) {
		
		// calls Edit member method from PhoneBookDirectory class
		int i = userDirectory.Edit(firstName, lastName);
		return i;
	}
	
	// defining sortUserDirectory method
	public void sortUserDirectory() {
		
		// calls SortbyID method from PhoneBookDirectory class
		userDirectory.SortbyID();
	}
	
	// defining linearSearchUserDirectory method
	public int linearSearchUserDirectory(String phoneNumber) {
		
		// calls LinearSearchByPhoneNumber member method from PhoneBookDirectory class
		int i = userDirectory.LinearSearchByPhoneNumber(phoneNumber);
		return i;
	}
	
	
}
