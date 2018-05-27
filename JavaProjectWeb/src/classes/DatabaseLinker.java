package classes;

import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSetMetaData;

public class DatabaseLinker {
	static Connection connection=null;
	public static void main(String[] args) throws ClassNotFoundException {
		
		try{
			connection= DriverManager.getConnection("jdbc:postgresql://localhost/postgres","kotz101","qwerty");
			System.out.println("Opened database successfully");
			connection.createStatement();
			System.out.println("Connectioned successfully");
		}
		catch(Exception Ae){
			System.out.println("ERROR");
		}
	}

	public static void LoadJDBCDriver() {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static boolean ConnectionIsValid() {
		LoadJDBCDriver();
		try {
			if (connection!=null) {
				return connection.isValid(50);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public static void CloseConnection() {
		LoadJDBCDriver();
		try {
	         if (connection != null) { connection.close(); }
	      }
	      catch (SQLException e) {
	         // log this error
	      }
	}
	public static void HaveOpenConection() {
		LoadJDBCDriver();
		if(!ConnectionIsValid()) {
			try{
			connection = DriverManager.getConnection("jdbc:postgresql://localhost/postgres","kotz101","qwerty");
			}catch(SQLException Ae){
				System.out.println("ERROR: "+Ae.getMessage());
			}
		}
	};

	public static List<Map<String, Object>> RSToLM(ResultSet rs){//it will tranlsate a ResultSet to List<Map<String, Object>> and close the ResultSet
		LoadJDBCDriver();
		List<Map<String, Object>> rows = new ArrayList<Map<String, Object>>();
		try{
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
			}
		catch(SQLException Ae){
			System.out.println("ERROR: "+Ae.getMessage());
		}

		return rows;
		
	}
	public static boolean IsUser(String username) {
		ResultSet rs=null;
		PreparedStatement stmt;
		LoadJDBCDriver();
		HaveOpenConection();
		try {
			stmt = connection.prepareStatement("SELECT 1 FROM public.User WHERE username=?");

			stmt.setString(1, username);
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
	public static User GetUser(String username) {
		ResultSet rs=null;
		PreparedStatement stmt=null;
		User user = new User(-1,"","","","");
		LoadJDBCDriver();
		HaveOpenConection();
		try {
			stmt = connection.prepareStatement("SELECT * FROM public.User WHERE username=?");

			stmt.setString(1, username);

			rs = stmt.executeQuery();
			if(rs.next()) {
				user = new User(rs.getInt("userid"),username,rs.getString("name"),rs.getString("surname"),rs.getString("department"),rs.getString("user_role"));
			}
			if (stmt != null) { stmt.close();}
			if (rs != null) { rs.close();}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user ;
	}
	public static boolean IsUserInProfession(Integer userid,String Profession) {
		ResultSet rs=null;
		PreparedStatement stmt=null;
		LoadJDBCDriver();
		HaveOpenConection();
		if(Arrays.asList("professor","secretary","student").contains(Profession)) {
			try {
				stmt = connection.prepareStatement("SELECT * FROM "+Profession+" WHERE user_id=?");
				stmt.setInt(1, userid);
				rs = stmt.executeQuery();
				boolean exists =  rs.next();
				if (stmt != null) { stmt.close();}
				if (rs != null) { rs.close();}
				return exists;
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

		return false;
	}
	public static List<Course> GetCourses() {
		List<Course> courses = new ArrayList<>();
		ResultSet rs=null;
		Statement stmt=null;
		LoadJDBCDriver();
		HaveOpenConection();
		try {
			stmt = connection.createStatement();
			rs = stmt.executeQuery("SELECT * FROM Course");
			while (rs.next()) {
				Course course = new Course(rs.getInt("courseid"),rs.getString("coursename"),rs.getString("coursedepartment"),rs.getString("coursesemester"));
				courses.add(course);
			}
			if (stmt != null) { stmt.close();}
			if (rs != null) { rs.close();}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return courses;
	}
	public static List<Map<String, Object>> GetCoursesAndProfessors() {
		List<Map<String, Object>> lm = new ArrayList<>();
		ResultSet rs=null;
		Statement stmt=null;
		LoadJDBCDriver();
		HaveOpenConection();
		try {
			stmt = connection.createStatement();
			rs = stmt.executeQuery("Select course.*, public.user.name , public.user.surname,professor.professorafm from professor,professor_course,course,public.user\n" + 
					"where (professor.user_id = public.user.userid) and (professor_course.professorafm = professor.professorafm) and (professor_course.course_id = course.courseid)");
			lm = RSToLM(rs);
			if (stmt != null) { stmt.close();}
			if (rs != null) { rs.close();}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lm;
	}
	public static boolean SetCourseToProfessor(Integer professorafm,Integer course_id) {
		ResultSet rs=null;
		PreparedStatement stmt=null;
		LoadJDBCDriver();
		
		try {
			
			stmt = connection.prepareStatement("SELECT * FROM PROFESSOR WHERE professorafm=?");
			stmt.setInt(1, professorafm);
			HaveOpenConection();
			rs = stmt.executeQuery();
			if(!rs.next()) {
				if (stmt != null) { stmt.close();}
				if (rs != null) { rs.close();}
				return false;
			}
			HaveOpenConection();
			stmt = connection.prepareStatement("SELECT * FROM COURSE WHERE courseid=?");
			stmt.setInt(1, course_id);
			rs = stmt.executeQuery();
			if(!rs.next()) {
				if (stmt != null) { stmt.close();}
				if (rs != null) { rs.close();}
				return false;
			}
			
			stmt = connection.prepareStatement("select * from professor_course where professorafm=? and course_id=?");
			stmt.setInt(1, professorafm);
			stmt.setInt(2, course_id);
			rs = stmt.executeQuery();
			if(rs.next()) {
				if (stmt != null) { stmt.close();}
				if (rs != null) { rs.close();}
				return false;
			}
			stmt = connection.prepareStatement("INSERT INTO professor_course(professorafm, course_id) VALUES (?,?)");
			stmt.setInt(1, professorafm);
			stmt.setInt(2, course_id);
			HaveOpenConection();
			stmt.execute();
			if (stmt != null) { stmt.close();}
			if (rs != null) { rs.close();}
			return true;
			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}