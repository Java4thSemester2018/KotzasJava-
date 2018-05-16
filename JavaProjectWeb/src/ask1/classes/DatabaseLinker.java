package ask1.classes;

import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSetMetaData;

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
	public static List<Map<String, Object>> RunQuery(String Query){
		Connection c=null;
		Statement stmt=null;
		ResultSet rs=null;
		List<Map<String, Object>> rows = new ArrayList<Map<String, Object>>();
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
			ResultSetMetaData md = rs.getMetaData();
			int columns = md.getColumnCount();
			    
			while (rs.next()){
				Map<String, Object> row = new HashMap<String, Object>(columns);
					for(int i = 1; i <= columns; ++i){
							row.put(md.getColumnName(i), rs.getObject(i));
						}
						rows.add(row);
					}
			if(rs!=null) {rs.close();}
			if(stmt!=null) {stmt.close();}
			if(c!=null) {c.close();}
			}
		catch(SQLException Ae){
			System.out.println("ERROR: "+Ae.getMessage());
		}

		return rows;
		
	}
	public static boolean IsUser(String username) {
		List<Map<String, Object>> Rows = RunQuery("SELECT 1 FROM Users WHERE username='"+username+"'");
		return Rows.size()>0;
	}
	public static User GetUser(String username) {
		List<Map<String, Object>> Rows = RunQuery("SELECT * FROM Users WHERE username='"+username+"'");
		Integer userid=-1;
		String name="";
		String surname="";
		String dep="";
		if(Rows.size()>0) {
			userid = (Integer)Rows.get(0).get("userid");
			name=(String)Rows.get(0).get("name");
			surname=(String)Rows.get(0).get("surname");
			dep=(String)Rows.get(0).get("department");
		}
		return new User(userid,username,name,surname,dep);
	}
	public static boolean IsUserInProfession(Integer userid,String Profession) {
		boolean exists =false;
		if(Arrays.asList("professors","secretaries","students").contains(Profession)) {
			List<Map<String, Object>> Rows = RunQuery("SELECT * FROM "+Profession+" WHERE user_id='"+userid+"'");
			exists = Rows.size()>0;
		}

		return exists;
	}
	public static List<Course> GetCourses(String Name) {
		List<Course> courses = new ArrayList<>();
		List<Map<String, Object>> Rows = RunQuery("SELECT * FROM Courses");
		for (Map<String, Object> row:Rows) {
			Course course = new Course((Integer)row.get("courseid"),(String)row.get("coursename"),(String)row.get("coursedepartment"),(String)row.get("coursesemester"));
			courses.add(course);
		}
		return courses;
	}
	public static List<Map<String, Object>> GetCoursesAndProfessors() {
		return RunQuery("Select courses.*, users.name , users.surname from professors,professors_courses,courses,users\n" + 
				"where (professors.user_id = users.userid) and (professors_courses.professorafm = professors.professorafm) and (professors_courses.course_id = courses.courseid)");
	}
	public static void SetCourseToProfesor(String professorafm,Integer course_id) {
		RunQuery("INSERT INTO public.professors_courses(professorafm, course_id) VALUES ("+professorafm+","+course_id+");");
	}
}