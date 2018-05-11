package ask1.classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseLinker {
	
	public static void main(String[] args) throws ClassNotFoundException {

		// TODO Auto-generated method stub
		int count=0;
		Connection c=null;
		Statement stmt=null;
		ResultSet rs=null;
		try{
			c= DriverManager.getConnection("jdbc:postgresql://localhost/postgres","kotz101","qwerty");
			System.out.println("Opened database successfully");
			stmt=c.createStatement();
			System.out.println("Created statement successfully");
		}
		catch(Exception Ae){
			System.out.println("ERROR");
		}
	}
	public static boolean IsUser(String Name) {
		int count=0;
		Connection c=null;
		Statement stmt=null;
		ResultSet rs=null;

		try{
			c= DriverManager.getConnection("jdbc:postgresql://localhost/postgres","kotz101","qwerty");
			System.out.println("Opened database successfully");
			stmt=c.createStatement();
			rs = stmt.executeQuery("SELECT 1 FROM Users WHERE username='"+Name+"'");
			return rs.next();
		}
		catch(Exception Ae){
			System.out.println("ERROR: "+Ae.getMessage());
		}
		return false;
	}
}