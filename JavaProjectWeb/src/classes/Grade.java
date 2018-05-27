package classes;
public class Grade {

	private String courseID;
	private int studentRegistrationNumber;
	private int grade;
	
	public Grade(int stud_RegistrationNumber,String course_id,int gradee) {
		studentRegistrationNumber=stud_RegistrationNumber;
		courseID=course_id;
		grade=gradee;
	}
	
	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}
	
	public void setStudentID(int stud_RegistrationNumber) {
		this.studentRegistrationNumber = stud_RegistrationNumber;
	}
	
	public void setGrade(int grade) {
		this.grade = grade;
	}
	
	public String getCourseID() {
		return courseID;
	}
	
	public int getStudentRegistrationNumber() {
		return studentRegistrationNumber;
	}
	
	public int getGrade() {
		return grade;
	}
}
