import java.io.*;
import java.util.Scanner;

public class PhoneBookApplication {
	
	static Scanner input = new Scanner(System.in);
	
	public static void main(String [] args) {
		
		// declaring and initializing String objects containing the name of the text files containing admin and user attributes
		String adminFile = "PhoneBookAdminInformation.txt";
		String normalUserFile = "NormalUserInformation.txt";
		
		// prompting user to enter login information
		System.out.println("Login:");
		System.out.print("Enter username: ");
		String inputUsername = input.next();
		
		System.out.print("Enter password: ");
		String inputPassword = input.next();
		
		System.out.println();
		
		boolean loggedIn = false;
		
		
		try {
			
			// instantiating FileReader object, then BufferedReader object, to read text files
			FileReader fileReaderAdmin = new FileReader(adminFile);
			BufferedReader bufferedReaderAdmin = new BufferedReader(fileReaderAdmin);
			
			String adminLine;
			
			// parsing through data in text file
			while ((adminLine = bufferedReaderAdmin.readLine()) != null) {
				
				// using split method to generate an array of Strings from the text file
				// with each element separated by a comma character in the text file
				String[] adminInfo = adminLine.split(",");
				
				String adminUsername = adminInfo[0];
				String adminPassword = adminInfo[1];
				String adminEmail = adminInfo[2];
				
				// creating PhoneBookAdmin object by calling PhoneBookAdmin constructor that takes username, password, and email
				// note: admin object ref var is 'larry, normal user object ref var is jay
				PhoneBookAdmin larry = new PhoneBookAdmin(adminUsername, adminPassword, adminEmail);
				
				// if user is not logged in as normal user, and username and password match the admin object's data field
				if (!loggedIn && inputUsername.equals(larry.getUsername()) && inputPassword.equals(larry.getPassword())) {
					
					loggedIn = true;
					
					int choice = -1;
					
					// continuously displaying admin edit menu to user and prompting them to select a choice
					while (choice != 10) {
						
						choice = adminMenu();
						
						if (choice == 1) {
							
							PhoneBookEntry obj = createEntry();
							
							larry.addUserEntry(obj);
						}
						
						else if (choice == 2) {
							
							System.out.print("Enter first name of entry to edit: ");
							String editFirstName = input.next();
							
							System.out.print("Enter last name of entry to edit: ");
							String editLastName = input.next();
							
							larry.editUserEntry(editFirstName, editLastName);
						}
						
						else if (choice == 3) {
							
							System.out.print("Enter first name of entry to delete: ");
							String deleteFirstName = input.next();
							
							System.out.print("Enter last name of entry to delete: ");
							String deleteLastName = input.next();
							
							larry.deleteUserEntrybyName(deleteFirstName, deleteLastName);
							
						}
						
						else if (choice == 4) {
							
							larry.sortUserDirectory();
						}
						
						else if (choice == 5) {
							
							System.out.println("Enter phone number to search with: ");
							String searchNumber = input.next();
							
							larry.linearSearchUserDirectory(searchNumber);
						}
						
						else if (choice == 6) {
							
							System.out.println("Enter id to search with: ");
							int searchID = input.nextInt();
							
							larry.binarySearchUserDirectory(searchID);
						}
						
						else if (choice == 7) {
							
							larry.PrintUserInfo();
						}
						
						else if (choice == 8) {
							
							System.out.print("Enter your new password: ");
							String newPassword = input.next();
							
							larry.changePassword(newPassword);
						}
						
						else if (choice == 9) {
							
							System.out.print("Enter your new username: ");
							String newUsername = input.next();
							
							larry.changeUsername(newUsername);
						}
						
						else {
							
							System.out.println("Invalid choice selected.");
						}
					}
					
					
					
				}
			}
			
			// same logic as lines 29-143, but for NormalUser object
			FileReader fileReaderUser = new FileReader(normalUserFile);
			BufferedReader bufferedReaderUser = new BufferedReader(fileReaderUser);
			
			String userLine;
			
			while ((userLine = bufferedReaderUser.readLine()) != null) {
				
				String[] userInfo = userLine.split(",");
				
				// converts string to integer data type
				int userID = Integer.parseInt(userInfo[0]);
				
				String userUsername = userInfo[1];
				String userPassword = userInfo[2];
				
				// creating NormalUser object by calling NormalUser object
				NormalUser jay = new NormalUser(userID, userUsername, userPassword);
				
				// if user is not logged in as admin, and username and password match the normal user object's data field
				if (!loggedIn && inputUsername.equals(jay.getUsername()) && inputPassword.equals(jay.getPassword())) {
					
					loggedIn = true;
					
					int choice = -1;
					
					while (choice != 6) {
						
						choice = userMenu();
						
						if (choice == 1) {
							
							PhoneBookEntry obj = createEntry();
							
							jay.addUserEntry(obj);
						}
						
						else if (choice == 2) {
							
							System.out.print("Enter first name of entry to edit: ");
							String editFirstName = input.next();
							
							System.out.print("Enter last name of entry to edit: ");
							String editLastName = input.next();
							
							jay.editUserEntry(editFirstName, editLastName);
						}
						
						else if (choice == 3) {
							
							jay.sortUserDirectory();
						}
						
						else if (choice == 4) {
							
							System.out.println("Enter phone number to search with: ");
							String searchNumber = input.next();
							
							jay.linearSearchUserDirectory(searchNumber);
						}
						
						
						else if (choice == 5) {
							
							jay.PrintUserInfo();
						}
						
						else {
							
							System.out.println("Invalid choice selected.");
						}
					}
					
				}
			}
			
			bufferedReaderAdmin.close();
			bufferedReaderUser.close();
			
		}
		
		// exception handling if file we are attempting to read is not found
		catch (FileNotFoundException e) {
			
			System.out.println("File '" + adminFile + "' not found." );
		}
		
		// exception handling if error occurs when reading file
		catch (IOException e) { 
			
			System.out.println("Error reading '" + adminFile + "'.");
		}
		
		// if user-entered username and password do not match Admin OR NormalUser data fields
		if (!loggedIn) {
			
			System.out.println("Login failed. Username or password incorrect.\n");
		}
	}
	
	// defining adminMenu method: displays admin menu to user, prompts user to choose an option, returns user choice
	public static int adminMenu() {
		
		System.out.println("Admin Menu: ");
		System.out.println("1. Add a phone entry");
		System.out.println("2. Edit a phone entry of a given first name and last name");
		System.out.println("3. Delete a phone entry of a given first name and last name");
		System.out.println("4. Sort the PhoneBookDirectory");
		System.out.println("5. Search using Linear Search (by phone number)");
		System.out.println("6. Search using Binary Search (by id)");
		System.out.println("7. Print Admin information");
		System.out.println("8. Change Password");
		System.out.println("9. Change Username");
		System.out.println("10. Exit");
		System.out.print("Enter your choice as an integer: ");
		int choice = input.nextInt();
		
		System.out.println();
		return choice;

	}
	
	// defining userMenu method: displays normal user menu to user, prompts user to choose an option, returns user choice
	public static int userMenu() {
		
		System.out.println("User Menu: ");
		System.out.println("1. Add a phone entry");
		System.out.println("2. Edit a phone entry of a given first name and last name");
		System.out.println("3. Sort the PhoneBookDirectory");
		System.out.println("4. Search using Linear Search (by phone number)");
		System.out.println("5. Print User information");
		System.out.println("6. Exit");
		System.out.print("Enter your choice as an integer: ");
		int choice = input.nextInt();
		
		System.out.println();
		return choice;

	}
	
	// defining createEntry method: creates and returns a PhoneBookEntry object with user-entered arguments
	public static PhoneBookEntry createEntry() {
		
		// prompting user to enter all data fields for PhoneBookEntry object
		System.out.print("Enter ID: ");
		int entryID = input.nextInt();
		
		System.out.print("Enter first name: ");
		String entryFirstName = input.next();
		
		System.out.print("Enter last name: ");
		String entryLastName = input.next();
		
		System.out.print("Enter email: ");
		String entryEmail = input.next();
		
		System.out.print("Enter zipcode: ");
		int entryZipcode = input.nextInt();
		
		System.out.print("Enter phone number: ");
		String entryPhoneNumber = input.next();
		
		// creating a PhoneBookEntry object by calling PhoneBookEntry constructor that takes all data fields as arguments
		PhoneBookEntry entryObj = new PhoneBookEntry(entryID, entryFirstName, entryLastName, entryEmail, entryZipcode, entryPhoneNumber);
		
		// returning created object
		return entryObj;
	}
}
