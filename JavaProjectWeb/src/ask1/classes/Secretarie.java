package ask1.classes;
import java.util.ArrayList;
import java.util.List;


public class Secretarie extends User{
	
	private int secretaryAFM;
	public static List<Professor> professors=new ArrayList<Professor>();
	private static List<Student> students=new ArrayList<Student>();
	public static List<Course> courses=new ArrayList<Course>();
	public static List<Grade> grades=new ArrayList<Grade>();
	//Οι μεταβλητές είναι public έτσι ώστε στην περίπτωση που ο professor θέλει να φτιάξει 
	//βαθμούς να μην είναι αναγκιαία η δημιουργία και αντικειμένου Secretaries
	
	
	public Secretarie(int k) {
		super();
		secretaryAFM = k;
	}

	public int getSecretaryAFM() {
		return secretaryAFM;
	}
	
	
	
	//FUNCTIONS
	
	public boolean setProfCourseID(String s,String id){//Αναθέτει στον καθηγητή ένα μάθημα
		//Ελέγχει αν υπάρχει μάθημα με αυτό το id
		boolean exists=true;
		for (int i=0;i<courses.size();i++){
			if (id.equals((courses).get(i))){
				exists=true;
				break;
			}
			else{
				exists=false;
			}
		}
		if (exists){//Ψάχνει τον Professor με professorAFM = s και εκεί
			//αναθέτει το id μαθήματος σε αυτόν
			for (int i=0;i<professors.size();i++){
				if (s.equals(((Professor)professors.get(i)).getProfessorAFM())){//Cast το object της λίστας σαν professor
					//Έλεγχος αν το έχει ήδη αυτό το μάθημα αυτός ο καθηγητής (OK)
					boolean ok=true;
					for (int j=0;i<((Professor)professors.get(i)).getCourse_ID().size();i++){
						if (id.equals((((Professor)professors.get(i))).getCourse_ID().get(j))){
							ok=false;
							break;
						}
					}
					//Αν δεν το έχει ήδη τότε το αναθέτει σε αυτόν.
					if (ok){
					((Professor)professors.get(i)).setCourse_ID(id); //Θέτει στον καθηγητή το course 
					return true;
					}
					else{
						
						System.out.print("Ο καθηγητης αυτος εχει ηδη το μαθημα με ID"+id);
						return false;
					}
				}
			}
		}
		else{
			System.out.print("Δεν υπαρχει μαθημα με αυτο το ID");
		}
		return false;
	}

	
	public void setStudentCourses(int am,String id){//Αναθέτει στο μαθητή ενα μάθημα
		//Βρίσκουμε τον μαθητή
		for (int i =0;i<students.size();i++){
			if (am==(((Student)students.get(i)).getRegistrationNumber())){//Έλεγχος αν το έχει ηδη
				boolean ok=true;
				for (int j=0;i<((Student)students.get(i)).getRegisteredCourses().size();i++){
					if (id.equals((((Student)students.get(i))).getRegisteredCourses().get(j))){
						ok=false;
						break;
					}
				}
				//Αν δεν το έχει ηδη τότε το αναθέτει σε αυτόν
				if (ok){
				((Student)students.get(i)).setRegisteredCourses(id);
				}
				else{
					System.out.print("Ο μαθητης αυτος εχει ηδη το μαθημα με ID"+id);
				}
				break; //Δε χρειάζεται να ψάξουμε όλους τους μαθητές
			}
		}
	}
	
	
	
	public void enlistStudent(Student k){//Η γραμματεία μπορεί να δημιουργεί εγγραφές φοιτητών
		boolean ok=true;
		for (int i =0;i<students.size();i++){
			if (k.getRegistrationNumber()==((Student)students.get(i)).getRegistrationNumber()){
				ok=false;
			}
		}
		if (ok){
		students.add(k);
		System.out.print("Ο/Η φοιτητης/τρια με \n ΑΜ:"+k.getRegistrationNumber()
				+"\n Username : "+k.getUsername()+
				"\n Ονομα : "+k.getName()+
				"\n Επιθετο : "+k.getSurname()+
				"\n Σχολη : "+k.getDepartment()+" \n Eγγραφθηκε \n");
		}else{
			System.out.print("Υπαρχει ηδη αυτος ο μαθητης\n");
		}
	}
	
	public void makeProfessors(int k){//Η γραμματεία μπορεί να δημιουργεί εγγραφές καθηγητών
		professors.add(new Professor(k));
	}
	
	public void makeCourses(){//Η γραμματεία μπορεί να δημιουργεί εγγραφές μαθημάτων
		courses.add(new Course());
	}
}
