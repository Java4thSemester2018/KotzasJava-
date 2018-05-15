package ask1.classes;
import java.util.ArrayList;
import java.util.List;


public class Student extends User {
	
	private int registrationNumber;
	private List<String> registeredCourses=new ArrayList<String>();//Λίστα μαθημάτων που έχει επιλέξει ο κάθε μαθητής
	
	public Student(int l){
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
		for (int i=0;i<Secretarie.courses.size();i++){
			if (courseID.equals((Secretarie.courses.get(i)))){
				exists=true;
				break;
			}
			else{
				exists=false;
			}
		}
		if (exists){
			//Αν υπάρχει πρέπει να το έχει και το grades
			for (int i=0;i<Secretarie.grades.size();i++){
				if (registrationNumber==(((Grade)Secretarie.grades.get(i)).getStudentRegistrationNumber())){
					if (courseID.equals(((Grade)Secretarie.grades.get(i)).getCourseID())){
						return ((Grade)Secretarie.grades.get(i)).getGrade();
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
