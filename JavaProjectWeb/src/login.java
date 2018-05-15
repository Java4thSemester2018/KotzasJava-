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
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		if(DatabaseLinker.IsUser(username)) {
			User user= DatabaseLinker.GetUser(username);
			request.setAttribute("username", user.getUsername()); 
			request.setAttribute("name", user.getName()); 
			request.setAttribute("surname", user.getSurname()); 
			request.setAttribute("dep", user.getDepartment()); 
			request.getRequestDispatcher("profile.jsp").forward(request,response);
		}else {
			response.sendRedirect("login.jsp");
		}
	}

}
