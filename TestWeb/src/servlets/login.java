package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ;
		}
		String username = request.getParameter("username");
		String name="",surname="",dep="";
		Connection c=null;
		Statement stmt=null;
		boolean kay=false;
		ResultSet rs=null;

		try{
			c= DriverManager.getConnection("jdbc:postgresql://localhost/postgres","kotz101","qwerty");
			System.out.println("Opened database successfully");
			stmt=c.createStatement();
			rs = stmt.executeQuery("SELECT 1 FROM Users WHERE username='"+username+"'");
			
			rs= stmt.executeQuery("SELECT * FROM Users WHERE username='"+username+"'");
			rs.next();
			name=rs.getString(3);
			surname=rs.getString(4);
			dep=rs.getString(5);
			kay=true;
		}
		catch(Exception Ae){
			System.out.println("ERROR: "+Ae.getMessage());
		}
		if(kay) {
			request.setAttribute("username", username); 
			request.setAttribute("name", name); 
			request.setAttribute("surname", surname); 
			request.setAttribute("dep", dep); 
			request.getRequestDispatcher("profile.jsp").forward(request,response);
		}else {
			response.sendRedirect("login.jsp");
		}
		
	}
	
}
