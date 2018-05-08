package mainpackage;
public class Grades {

	private String courseID;
	private int studentID;
	private int grade;
	
	public Grades(int stud_id,String course_id,int gradee) {
		studentID=stud_id;
		courseID=course_id;
		grade=gradee;
	}
	
	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}
	
	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}
	
	public void setGrade(int grade) {
		this.grade = grade;
	}
	
	public String getCourseID() {
		return courseID;
	}
	
	public int getStudentID() {
		return studentID;
	}
	
	public int getGrade() {
		return grade;
	}
}
