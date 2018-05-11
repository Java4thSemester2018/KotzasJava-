package ask1.classes;
public class Courses {
	private int courseId ;
	private String courseName;
	private String courseDepartment;
	private String courseSemester;
	
	public Courses(){
		
	}
	
	//FUNCTIONS
	public void setCourseId(int k){
		courseId=k;
	}
	public void setCourseName(String k){
		courseName=k;
	}
	public void setCourseDepartment(String k){
		courseDepartment=k;
	}
	public void setCourseSemester(String k){
		courseSemester=k;
	}
	public int getCourseId(){
		return courseId;
	}
	public String getCourseName(){
		return courseName;
	}
	public String getCourseDepartment(){
		return courseDepartment;
	}
	public String getCourseSemester(){
		return courseSemester;
	}
}
