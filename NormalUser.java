// defining a child class of the User class
public class NormalUser extends User implements NormalUserInterface {
	
	// member variables
	
	private int userID;
	
	// constructors
	
	// default constructor
	public NormalUser() {
		
		// invokes no-arg constructor from parent class
		super();
		
		// default userID value is -1
		userID = -1;
	}
	
	// constructor that accepts passed userID, username, and password
	public NormalUser(int userID, String username, String password) {
		
		// invokes parent class constructor that accepts username and password
		super(username, password);
		this.userID = userID;
	}
	
	@Override
	public void PrintUserInfo() {
		
		System.out.println("User Info:");
		System.out.println("User ID: " + userID);
		System.out.println("Username: " + username);
		System.out.println("Password: " + password);
		System.out.println("Directory: ");
		userDirectory.printAllEntries();
	}
	
}
