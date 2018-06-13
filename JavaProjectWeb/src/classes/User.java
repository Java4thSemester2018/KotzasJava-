package classes;
public class User {
	private Integer userid;
	private String username;
	private String name;
	private String surname;
	private String department;
	private String role;
	private String password;
	private String salt;
	//private static int usersCounter=0;
	public User() {}

	public User(Integer userid,String username, String password, String salt,String name,String surname,String department,String role) {
		
		this.userid =userid;
		this.username = username;
		this.name = name;
		this.password = password;
		this.salt = salt;
		this.surname = surname;
		this.department = department;
		this.role = role;
		//usersCounter++;
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
	public Integer getUserid() {
		return userid;
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
	public String getRole() {
		return role;
	}
	//public int getUsersCounter() {
	//	return usersCounter;
	//}
}