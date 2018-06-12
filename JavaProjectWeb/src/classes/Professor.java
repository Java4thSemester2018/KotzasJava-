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