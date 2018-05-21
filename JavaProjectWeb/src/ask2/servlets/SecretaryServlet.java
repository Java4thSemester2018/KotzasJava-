package ask2.servlets;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ask1.classes.Course;
import ask1.classes.DatabaseLinker;
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
		String option = request.getParameter("option");
		boolean fromAssign = request.getParameter("assign")!=null;
		String name = request.getParameter("name");
		request.setAttribute("username",name);
		String s="";
		if(fromAssign) {
    		try {
    			int courseid = Integer.parseInt(request.getParameter("courseid"));
    			int profafm = Integer.parseInt(request.getParameter("professorafm"));
    			boolean done = DatabaseLinker.SetCourseToProfessor(profafm,courseid);
    			System.out.println("done="+done);
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
        	 		 s+="<tr><th>Courses</th></tr>\n";
        	 		 for(Course cr:crs) {
        	 			 s += "<tr>";
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
                	 System.out.println("fromAssign="+fromAssign);
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
