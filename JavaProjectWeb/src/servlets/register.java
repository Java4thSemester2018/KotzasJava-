package servlets;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import classes.DatabaseLinker;
import classes.User;
/**
 * Servlet implementation class login
 */
@WebServlet("/register")
public class register extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("register.jsp").forward(request, response);
	}
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String name=request.getParameter("name");
		String surname=request.getParameter("surname");
		String department=request.getParameter("department");
		String role=request.getParameter("role");
		if(!DatabaseLinker.IsUser(username)) {
			User user=null;
			try {
				DatabaseLinker.CreateUser(username, password, name, surname, department, role);
				user = DatabaseLinker.GetUser(username, password);
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    HttpSession session = request.getSession(true);
		    session.setAttribute("username", user.getUsername()); 
			session.setAttribute("name", user.getName()); 
			session.setAttribute("surname", user.getSurname()); 
			session.setAttribute("dep", user.getDepartment()); 
			session.setAttribute("role", user.getRole());
			request.getRequestDispatcher(Character.toUpperCase(user.getRole().charAt(0)) + user.getRole().substring(1)+"Servlet").forward(request,response);
			return;
		}
		request.setAttribute("message", "This user exists already!");
		request.getRequestDispatcher("register.jsp").forward(request,response);
	}
}