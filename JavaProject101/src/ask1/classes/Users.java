package ask1.classes;
public class Users {

	private String username;
	private String name;
	private String surname;
	private String department;
	private static int usersCounter=0;
	
	public Users() {
		usersCounter++;
	}
	
	
	
	//FUNCTIONS

	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public void setDepartment(String department) {
		this.department = department;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getName() {
		return name;
	}
	
	public String getSurname() {
		return surname;
	}
	
	public String getDepartment() {
		return department;
	}
	
	public int getUsersCounter() {
		return usersCounter;
	}
}