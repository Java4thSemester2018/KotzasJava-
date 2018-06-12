package classes;

import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSetMetaData;

public class Professor extends User{
	static Connection connection=null;
	private int professorAFM;
	private List<String> courseIDs=new ArrayList<String>(); //Βάζει το μάθημα του professor
	public Professor(int k){
		super();
		professorAFM = k;
	}

	
	//FUNCTIONS
	public int getProfessorAFM() {
		return professorAFM;
	}
	public void setCourse_ID(String k ){
		courseIDs.add(k);
	}
	public List<String> getCourse_ID( ){
		return courseIDs;
	}
	//to check if the lesson for this stud has grade on it

	
	public static boolean setGrade(int studentID, int courseID, int grade) {
		ResultSet rs=null;
		PreparedStatement stmt;
		DatabaseLinker.LoadJDBCDriver();
		DatabaseLinker.HaveOpenConection();
		try {
			stmt = connection.prepareStatement("INSERT INTO GRADES VALUES("+studentID+","+courseID+","+grade+")");
			rs = stmt.executeQuery();
			boolean exists =  rs.next();
			if (stmt != null) { stmt.close();}
			if (rs != null) { rs.close();}
			return exists;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public static List<Map<String, Object>> PrintCourses(int courseid) {
		List<Map<String, Object>> lm = new ArrayList<>();
		ResultSet rs=null;
		Statement stmt=null;
		DatabaseLinker.LoadJDBCDriver();
		DatabaseLinker.HaveOpenConection();
		try {
			stmt = connection.createStatement();
			rs = stmt.executeQuery("Select * from grade where courseid="+courseid);
			lm = DatabaseLinker.RSToLM(rs);
			if (stmt != null) { stmt.close();}
			if (rs != null) { rs.close();}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lm;
	}
	
	public void printGrades(){
		for (String course : courseIDs) {
			System.out.println("Course: ");
			
			for (Grade grade : Secretary.grades) {
				if(grade.getCourseID()==course) { //Ελέγχει για κάθε βαθμό αν αντιστοιχίζεται το μάθημα
					System.out.println(grade.getStudentRegistrationNumber()+": "+grade.getGrade());
				}
			    
			}
		    
		}
	}
}