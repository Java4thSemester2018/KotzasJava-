package servlets;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classes.DatabaseLinker;
import classes.Professor;

/**
 * Servlet implementation class ProfessorServlet
 */
@WebServlet("/ProfessorServlet")
public class ProfessorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfessorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String option = request.getParameter("option");
		boolean fromSetGrade = request.getParameter("SetGrade")!=null;
		boolean fromGradePerLes = request.getParameter("GradePerLes")!=null;
		String s="";
		if(fromSetGrade) {
    		try {
    			int courseid = Integer.parseInt(request.getParameter("courseID"));
    			int studid = Integer.parseInt(request.getParameter("studentID"));
    			int grade = Integer.parseInt(request.getParameter("grade"));
    			boolean done = DatabaseLinker.SetProfessorGradeToCourse(studid, courseid, grade);
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
		else if (fromGradePerLes){
			try {
    			int courseid = Integer.parseInt(request.getParameter("courseID"));
				int professorID = Integer.parseInt(request.getParameter("professorID"));
    			List<Map<String, Object>> done =  DatabaseLinker.GetProfessorGradeByCourse(professorID,courseid);
    			s = "<table border=\"0\" width=\"500\" align=\"center\">\n";
           	 s += "<tr> \n";
           		 for (Map.Entry<String, Object> rowEntry : done.get(0).entrySet()) {
           			 s+= "<th>"+rowEntry.getKey()+"</th>\n";
           		 }
           	 s += "</tr>\n";
           	 for (Map<String, Object> row:done) {
           		 s += "<tr> \n";
           		 for (Map.Entry<String, Object> rowEntry : row.entrySet()) {
           			 s+= "<td>"+rowEntry.getValue()+"</td>\n";
           		 }
           		 s += "</tr>\n";
           		 }
           	request.setAttribute("output",s);
			request.getRequestDispatcher("Professor.jsp").forward(request, response);
    		}catch(Exception Ae) {
    			
    			Ae.printStackTrace();
    		}
		}
		try {
            switch (option) {
                case "provoli":
					request.getRequestDispatcher("printcourses.jsp").forward(request, response);
                	break;
                case "setgrade":
                    request.getRequestDispatcher("setgrade.jsp").forward(request, response);
               	 	return;
            	default:
            }
		}
		catch(Exception AE){
        request.getRequestDispatcher("Professor.jsp").forward(request, response);

		}
	}

}
