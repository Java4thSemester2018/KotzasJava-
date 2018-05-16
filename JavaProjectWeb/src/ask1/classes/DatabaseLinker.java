package ask1.classes;

import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseLinker {
	
	public static void main(String[] args) throws ClassNotFoundException {
		Connection c=null;
		try{
			c= DriverManager.getConnection("jdbc:postgresql://localhost/postgres","kotz101","qwerty");
			System.out.println("Opened database successfully");
			c.createStatement();
			System.out.println("Connectioned successfully");
		}
		catch(Exception Ae){
			System.out.println("ERROR");
		}
	}
	public static ResultSet RunQuery(String Query){
		Connection c=null;
		Statement stmt=null;
		ResultSet rs=null;
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try{
			c= DriverManager.getConnection("jdbc:postgresql://localhost/postgres","kotz101","qwerty");
			System.out.println("Opened database successfully");
			stmt=c.createStatement();
			System.out.println("Connection open:"+(c!=null));
			rs = stmt.executeQuery(Query);
			System.out.println("ResultSet open:"+(rs!=null));
		}
		catch(Exception Ae){
			System.out.println("ERROR: "+Ae.getMessage());
		}
		
		return rs;
		
	}
	public static boolean IsUser(String username) {
		ResultSet rs = RunQuery("SELECT 1 FROM Users WHERE username='"+username+"'");
		try {
			boolean exists = rs.next();
			rs.close();
			return exists;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	public static User GetUser(String username) {
		ResultSet rs = RunQuery("SELECT * FROM Users WHERE username='"+username+"'");
		String name="";
		String surname="";
		String dep="";
		User User =new User();
		try {
			rs.next();
			name=rs.getString("name");
			surname=rs.getString("surname");
			dep=rs.getString("department");
			User= new User(username,name,surname,dep);
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return User;
	}
	public static List<Course> GetCourses(String Name) {
		List<Course> courses = new ArrayList<>();
		ResultSet rs = RunQuery("SELECT * FROM Courses");
		try {
			while(rs.next()) {
				Course course = new Course(rs.getInt("courseid"),rs.getString("coursename"),rs.getString("coursedepartment"),rs.getString("coursesemester"));
				courses.add(course);
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return courses;
	}
	public static ResultSet GetCoursesAndProfessors(String Name) {
		return RunQuery("Select courses.*, users.name , users.surname from professors,professors_courses,courses,users\n" + 
				"where (professors.user_id = users.userid) and (professors_courses.professorafm = professors.professorafm) and (professors_courses.course_id = courses.courseid)");
	}
	public static void SetCourseToProfesor(String professorafm,Integer course_id) {
		RunQuery("INSERT INTO public.professors_courses(professorafm, course_id) VALUES ("+professorafm+","+course_id+");");
	}
}