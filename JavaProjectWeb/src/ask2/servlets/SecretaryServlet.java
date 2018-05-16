package ask2.servlets;

import ask1.classes.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SecretaryServlet
 */
@WebServlet("/SecretaryServlet")
public class SecretaryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SecretaryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.setContentType("text/html");
//		try {
//		    request.getRequestDispatcher("/profile.jsp").include(request, response);
//		  } catch (ServletException e) {
//		    e.printStackTrace();
//		  }
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String option = request.getParameter("option");
        try {
             switch (option) {
                 case "Classes":
                     //3.4.2 request.setAttribute("img", "apples.jpg");
                     break;

                 case "Professors":
                	 //3.4.3
                	 //response.setContentType("text/html");
                	 
                	 List<Map<String, Object>> Rows = DatabaseLinker.GetCoursesAndProfessors();
                	 
                	 String s = "<table border=\"0\" width=\"500\" align=\"center\">\n";
                	 for (Map<String, Object> row:Rows) {
                		 s += "<tr> \n";
                		 for (Map.Entry<String, Object> rowEntry : row.entrySet()) {
                			 s+= "<th>"+rowEntry.getKey()+"</th>\n";
                		 }
                		 s += "</tr>\n";
                	 }
                	 for (Map<String, Object> row:Rows) {
                		 s += "<tr> \n";
                		 for (Map.Entry<String, Object> rowEntry : row.entrySet()) {
                			 s+= "<td>"+rowEntry.getValue()+"</td>\n";
                		 }
                		 s += "</tr>\n";
                		 }
                	 request.setAttribute("output",s);
                	 break;
                 case "Assign":
                	 //3.4.4
                	 break;
                 default:
                	 
             }
        }
        catch (Exception e){
        }
         request.getRequestDispatcher("Secretary.jsp").forward(request, response);
		
        }
	

}
