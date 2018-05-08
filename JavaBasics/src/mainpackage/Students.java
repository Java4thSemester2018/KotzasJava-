package mainpackage;
import java.util.ArrayList;
import java.util.List;


public class Students extends Users {
	
	private int registrationNumber;
	private List<String> registeredCourses=new ArrayList<String>();//Λίστα μαθημάτων που έχει επιλέξει ο κάθε μαθητής
	
	public Students(int l){
		super();

		registrationNumber=l;
	}
	
	
	
	//FUNCTIONS
	public void setRegisteredCourses(String id){
		registeredCourses.add(id);
	}
	
	public int getRegistrationNumber() {
		return registrationNumber;
	}
	
	public List<String> getRegisteredCourses() {
		return registeredCourses;
	}
	
	public int ReturnGrade(String courseID){//Επιστρέφει απο την γραμματεία το βαθμό
		//Ψάχνει αν υπάρχει το courseID
		boolean exists=true;
		for (int i=0;i<Secretaries.courses.size();i++){
			if (courseID.equals((Secretaries.courses.get(i)))){
				exists=true;
				break;
			}
			else{
				exists=false;
			}
		}
		if (exists){
			//Αν υπάρχει πρέπει να το έχει και το grades
			for (int i=0;i<Secretaries.grades.size();i++){
				if (registrationNumber==(((Grades)Secretaries.grades.get(i)).getStudentID())){
					if (courseID.equals(((Grades)Secretaries.grades.get(i)).getCourseID())){
						return ((Grades)Secretaries.grades.get(i)).getGrade();
					}
				}
			}
			//Αν φτάσει ως εδω ο κώδικας τότε δεν βρέθηκε η βαθμολογία
			System.out.print("Δεν βρεθηκε βαθμολογια για αυτο το μαθημα\n");
			return -1;
		
			
		}
		else{
			System.out.print("Δεν βρεθηκε το μαθημα\n");
			return -1;
		}
		
		
	}
}
