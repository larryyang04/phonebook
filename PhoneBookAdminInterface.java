
public interface PhoneBookAdminInterface {
	
	// abstract methods
	
	public void PrintUserInfo();
	
	public int deleteUserEntrybyName(String firstName, String lastName);
	
	public PhoneBookEntry binarySearchUserDirectory(int id);
	
	public void changePassword(String newPassword);
	
	public void changeUsername(String newUsername);
}
