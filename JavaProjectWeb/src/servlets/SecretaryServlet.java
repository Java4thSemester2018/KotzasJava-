package servlets;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import classes.Course;
import classes.DatabaseLinker;
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
		request.getRequestDispatcher("Secretary.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
        HttpSession session = request.getSession(true);
        if (!session.getAttribute("role").equals("secretary")){
        	response.sendRedirect("login");
        }
		String option = request.getParameter("option");
		boolean fromAssign = request.getParameter("assign")!=null;
		String s="";
		if(fromAssign && (request.getParameter("courseid") != null) && (request.getParameter("professorafm")!=null)) {
    		try {
    			int courseid = Integer.parseInt(request.getParameter("courseid"));
    			int profafm = Integer.parseInt(request.getParameter("professorafm"));
    			boolean done = DatabaseLinker.SetCourseToProfessor(profafm,courseid);
    			if (done) {
    			request.setAttribute("output","Done!");
    			}
    			else {
    			request.setAttribute("output","Error");
    			}
    			request.getRequestDispatcher("Secretary.jsp").forward(request, response);
    		}catch(Exception Ae) {
    			
    			Ae.printStackTrace();
    		}
    		
    	 }
        try {
             switch (option) {
                 case "Classes":
                	 //3.4.2 request.setAttribute("img", "apples.jpg");
                	 
        	 		 List<Course> crs= DatabaseLinker.GetCourses();
        	 		if(crs.size()>0) {
        	 		 s = "<table border=\"0\" width=\"500\" align=\"center\">\n";
        	 		 s+="<tr><th>Course Id</th><th>Course Name</th></tr>\n";
        	 		 for(Course cr:crs) {
        	 			 s += "<tr>";
        	 			s+="<td> "+cr.getCourseId()+"</td>";
        	 			 s+="<td> "+cr.getCourseName()+"</td>";
        	 			
        	 			 s += "</tr>";
        	 		 }
        	 		 s+="</table>";
                	 request.setAttribute("output",s);
        	 		}
                     break;

                 case "Professors":
                	 //3.4.3
                	 //response.setContentType("text/html");
                	 
                	 List<Map<String, Object>> Rows = DatabaseLinker.GetCoursesAndProfessors();
                	 if(Rows.size()>0) {
                	 s = "<table border=\"0\" width=\"500\" align=\"center\">\n";
                	 s += "<tr> \n";
                		 for (Map.Entry<String, Object> rowEntry : Rows.get(0).entrySet()) {
                			 s+= "<th>"+rowEntry.getKey()+"</th>\n";
                		 }
                	 s += "</tr>\n";
                	 for (Map<String, Object> row:Rows) {
                		 s += "<tr> \n";
                		 for (Map.Entry<String, Object> rowEntry : row.entrySet()) {
                			 s+= "<td>"+rowEntry.getValue()+"</td>\n";
                		 }
                		 s += "</tr>\n";
                		 }
                	 request.setAttribute("output",s);
                	 }
                	 break;
                 case "Assign":
                     request.getRequestDispatcher("assign.jsp").forward(request, response);
                	 return;
                 default:
                	 
             }
        }
        catch (Exception e){
            
        }
        request.getRequestDispatcher("Secretary.jsp").forward(request, response);
	}
}
