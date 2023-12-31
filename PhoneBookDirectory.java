import java.util.Scanner;

public class PhoneBookDirectory {
	
	// instantiating Scanner object as static outside of methods to be accessible in all methods
	static Scanner input = new Scanner(System.in);
	
	// member variables
	
	// creating array to store six PhoneBookEntry objects, and creating six default PhoneBookEntry objects by calling no-arg constructor
	private PhoneBookEntry[] directory = {
			
			new PhoneBookEntry(),
			new PhoneBookEntry(),
			new PhoneBookEntry(),
			new PhoneBookEntry(),
			new PhoneBookEntry(),
			new PhoneBookEntry(),
	};
	
	// getters and setters 
	
	public PhoneBookEntry[] getDirectory() {
		return directory;
	}
	
	// constructors
	
	// no-arg constructor
	public PhoneBookDirectory() {
		
	}
	
	// defining addEntry method: adds an entry to the array at first empty space
	public int addEntry(PhoneBookEntry entry) {
		
		// iterating through array
		for (int i = 0; i < directory.length; i++) {
			
			// checking if object at index i is empty (we define "empty" as default id (-1) and first name (empty)
			if (directory[i].getId() == -1 
					&& directory[i].getFirstName().equals("")) {
				
				// stores passed entry object into array, returns 1
				directory[i] = entry;
				System.out.println("Entry added successfully.\n");
				return 1;
			}
		}
		
		// returns 0 if no entry is added due to array being full
		System.out.println("The directory is full. No entry added.\n");
		return 0;
	}
	
	// defining printAllEntries method: prints all attributes of all non-empty PhoneBookEntry objects in the array
	public void printAllEntries() {
		
		boolean printed = false;
		
		for (int i = 0; i < directory.length; i++) {
			
			// checks if object at index i is not empty
			if (directory[i].getId() != -1 && !directory[i].getFirstName().equals("")) {
				
				// calls printBookEntry() method if not empty
				directory[i].printBookEntry();
				printed = true;
			}
		}
		
		// if all objects in array are empty
		if (!printed) {
			
			System.out.println("No entries stored in the directory.\n");
		}
	}
	
	// defining LinearSearchByPhoneNumber method: searches for an entry in the array with the passed phone number via linear search algorithm
	public int LinearSearchByPhoneNumber(String PhoneNumber) {
		
		for (int i = 0; i < directory.length; i++) {
			
			if (PhoneNumber.equals(directory[i].getPhoneNumber())) {
				
				// returns 1 if entry is found
				System.out.println("Entry found!\n");
				return 1;
			}
		}
		
		// returns 0 if entry is not found
		System.out.println("Entry does not exist.\n");
		return 0;
	}
	
	// defining SearchbyIDBinarySearch method: searches for an entry in the array with the passed id via binary search algorithm
	public PhoneBookEntry SearchbyIdBinarySearch(int id) {
		
		// calls SortbyID method, since binary search works only for sorted arrays
		SortbyID();
		
		// implementing binary search algorithm; logic for implementation guided by implementation shown in Chapter 7 of the textbook
		int lowIndex = 0;
		int highIndex = directory.length - 1;
		
		while (highIndex >= lowIndex) {
			
			int midIndex = (lowIndex + highIndex) / 2;
			
			if (id < directory[midIndex].getId()) {
				
				highIndex = midIndex - 1;
			}
			
			else if (id == directory[midIndex].getId()) {
				
				// returns entry associated with passed id if found
				System.out.println("Entry found!\n");
				return directory[midIndex];
			}
			
			else {
				
				lowIndex = midIndex + 1;
			}
		}
		
		// returns default PhoneBookEntry object if entry is not found
		System.out.println("Entry does not exist.\n");
		return new PhoneBookEntry();
	}
	
	// defining SortbyID method: sorts the array based on id values
	public void SortbyID() {
		
		// outer loop iterates through every element in array except final element
		// inner loop iterates through every element after index i
		for (int i = 0; i < directory.length - 1; i++) {
			
			for (int j = i + 1; j < directory.length; j++) {
				
				// if id of entry at index i is greater than index j, objects are swapped in the array, so lower id value is placed at index i
				if (directory[i].getId() > 
				directory[j].getId()) {
					
					PhoneBookEntry tempObj = directory[i];
					directory[i] = directory[j];
					directory[j] = tempObj;
				}
			}
		}
		
		System.out.println("Directory sorted.\n");
	}
	
	// defining SearchbyFirstNameLastName method: searches the array for an entry that matches the passed first and last names; returns index of found entry
	public int SearchbyFirstNameLastName(String firstName, String lastName) {
		
		for (int i = 0; i < directory.length; i++) {
			
			if (firstName.equals(directory[i].getFirstName())
					&& lastName.equals(directory[i].getLastName())) {
				
				// returns index i in array of matching entry
				System.out.println("Entry found!\n");
				return i;
			}
				
		}
		
		// returns -1 if entry is not found
		System.out.println("Entry does not exist.\n");
		return -1;
	}
	
	// defining EditMenu method: prints edit menu to user, returns integer representing user choice
	public int EditMenu() {
		
		System.out.println("Edit Menu: ");
		System.out.println("1. Edit ID");
		System.out.println("2. Edit First Name");
		System.out.println("3. Edit Last Name");
		System.out.println("4. Edit Email");
		System.out.println("5. Edit Zipcode");
		System.out.println("6. Edit Phone Number");
		System.out.print("Enter your choice as an integer: ");
		int choice = input.nextInt();
		return choice;
		
	}
	
	// defining Edit method: allows the user to edit any attribute of the entry that matches the passed first and last names
	public int Edit(String firstName, String lastName) {
		
		// calls SearchbyFirstNameLastName method to find index of entry to be edited
		int index = SearchbyFirstNameLastName(firstName, lastName);
		
		// checks if entry exists
		if (index != -1) {
			
			// calls EditMenu method to prompt user for action
			int choice = EditMenu();
			
			if (choice == 1) {
				
				System.out.print("Enter the new ID as an integer: ");
				directory[index].setId(input.nextInt());
				System.out.println("Entry edited!\n");
			}
			
			else if (choice == 2) {
				
				System.out.print("Enter the new first name as a string: ");
				directory[index].setFirstName(input.next());
				System.out.println("Entry edited!\n");
			}
			
			else if (choice == 3) {
				
				System.out.print("Enter the new last name as a string: ");
				directory[index].setLastName(input.next());
				System.out.println("Entry edited!\n");
			}
			
			else if (choice == 4) {
				
				System.out.print("Enter the new email as a string: ");
				directory[index].setEmail(input.next());
				System.out.println("Entry edited!\n");
			}
			
			else if (choice == 5) {
				
				System.out.print("Enter the new zipcode as an integer: ");
				directory[index].setZipCode(input.nextInt());
				System.out.println("Entry edited!\n");
			}
			
			else if (choice == 6) {
				
				System.out.print("Enter the new phone number as a string: ");
				directory[index].setPhoneNumber(input.next());
				System.out.println("Entry edited!\n");
			}
			
			else {
				
				System.out.println("Invalid option chosen.\n");
			}
			
			// returns 1 entry was found and user attempts to edit
			return 1;
		}
		
		else {
			
			// returns 0 if entry is not found and no edits are made
			System.out.println("No edits made.\n");
			return 0;
		}
		
	}
	
	// defining DeleteEntry method: deletes the entry of the passed id by setting all attributes to default value
	public int DeleteEntry(int id) {
		
		// calls SearchbyIdBinarySearch function to find entry object that matches passed id
		PhoneBookEntry keyObj = SearchbyIdBinarySearch(id);
		
		// if entry is not found (and binary search function returns default object)
		if (keyObj.getId() == -1 && keyObj.getFirstName().equals("")) {
			
			// returns 1 if entry not found and no edits made
			System.out.println("No entry found. No deletions made.\n");
			return 1;
		}
		
		// if entry is found
		else {
			
			// calls setter methods to set all attributes to default values -> "deleting them"
			keyObj.setId(-1);
			keyObj.setFirstName("");
			keyObj.setLastName("");
			keyObj.setEmail("");
			keyObj.setZipCode(0);
			keyObj.setPhoneNumber("");
			
			// returns 0 if the entry is found and deleted
			System.out.println("Entry deleted.\n");
			return 0;
			
		}
	}
	
}
