import java.io.IOException;

import ask1.classes.*;
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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String profession=request.getParameter("pro");
		if(DatabaseLinker.IsUser(username)) {
			User user= DatabaseLinker.GetUser(username);
			System.out.println(profession);
			if(user.getRole()!="guest"){
				request.setAttribute("username", user.getUsername()); 
				request.setAttribute("name", user.getName()); 
				request.setAttribute("surname", user.getSurname()); 
				request.setAttribute("dep", user.getDepartment()); 
				request.setAttribute("role", user.getRole());
				request.getRequestDispatcher(Character.toUpperCase(user.getRole().charAt(0)) + user.getRole().substring(1)+"Servlet").forward(request,response);
				return;
            }
		}
		request.setAttribute("message", "Couldn't login ...wrong username or profession");
		request.getRequestDispatcher("login.jsp").forward(request,response);
	}
}