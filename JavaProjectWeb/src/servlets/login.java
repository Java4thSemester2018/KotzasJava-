package servlets;
import java.io.IOException;

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
@WebServlet("/login")
public class login extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		if(DatabaseLinker.IsUser(username)) {
			User user= DatabaseLinker.GetUser(username);
			if(user.getRole()!="guest"){
		        HttpSession session = request.getSession(true);
				session.setAttribute("username", user.getUsername()); 
				session.setAttribute("name", user.getName()); 
				session.setAttribute("surname", user.getSurname()); 
				session.setAttribute("dep", user.getDepartment()); 
				session.setAttribute("role", user.getRole());
				request.getRequestDispatcher(Character.toUpperCase(user.getRole().charAt(0)) + user.getRole().substring(1)+"Servlet").forward(request,response);
				return;
            }
		}
		request.setAttribute("message", "Couldn't login ...wrong username");
		request.getRequestDispatcher("login.jsp").forward(request,response);
	}
}