package mainpackage;
import java.util.ArrayList;
import java.util.List;


public class Professors extends Users{

	private int professorAFM;
	private List<String> courseIDs=new ArrayList<String>(); //Βάζει το μάθημα του professor
	public Professors(int k){
		super();
		professorAFM = k;
	}

	
	//FUNCTIONS
	public int getProfessorAFM() {
		return professorAFM;
	}
	public void setCourse_ID(String k ){
		courseIDs.add(k);
	}
	public List<String> getCourse_ID( ){
		return courseIDs;
	}

	public void setGrade(String courseID, int studentID, int grade) {
		if (courseIDs.equals(courseID)) {
			System.out.print("Το μάθημα βρέθηκε");
			System.out.print("Αντιστοιχίζεται το studentID με αυτό που θέλει ο καθηγητής");
			System.out.print("Αν δεν υπάρχει το αντίστοιχο grade δημιουργείται, αλλιώς το αλλάζει.");
			
		}
	}
	
	public void printGrades(){
		for (String course : courseIDs) {
			System.out.println("Course: ");
			
			for (Grades grade : Secretaries.grades) {
				if(grade.getCourseID()==course) { //Ελέγχει για κάθε βαθμό αν αντιστοιχίζεται το μάθημα
					System.out.println(grade.getStudentID()+": "+grade.getGrade());
				}
			    
			}
		    
		}
	}
}