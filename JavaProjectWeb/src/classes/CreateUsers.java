package classes;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class CreateUsers {


	public static void main(String[] args) {
		Scanner reader=new Scanner(System.in);
		
		
		//Secretaries
		boolean ok=false;
		Secretary s=null;
		while(!ok){
			try{
				System.out.print("ΑΦΜ Γραμματεα:\n");
				s=new Secretary(reader.nextInt());
				System.out.print("ο Γραμματεας εγγραφθηκε "+"\n");
				ok=true;
			}
			catch(Exception A){
				System.out.print("Λανθασμενο ΑΦΜ\n");
				ok = false;	
				reader.nextLine();//Για αποφυγή του infinite loop, για να καθαρίζει το scanner
				continue;

			}
		}
		System.out.print("###########################\n");
		System.out.print("ΑΦΜ εγγραμμενου Γραμματεα:\n");
		System.out.print(s.getSecretaryAFM()+"\n");
		
		
		//Students
		ok=false;
		Student ka=null;
		while(!ok){
			try{
				System.out.print("ΑΜ Φοιτητη:\n");
				ka=new Student(reader.nextInt());
				System.out.print("ο Φοιτητης εγγραφθηκε "+"\n");
				ok=true;
			}
			catch(Exception A){
				System.out.print("Λανθασμενο ΑΜ\n");
				ok = false;	
				reader.nextLine();
				continue;

			}
		}
		System.out.print("Username Φοιτητη:\n");
		ka.setUsername(reader.next());
		System.out.print("Ονομα Φοιτητη:\n");	
		ka.setName(reader.next());
		System.out.print("Επιθετο Φοιτητη:\n");
		ka.setSurname(reader.next());
		System.out.print("Τμημα Φοιτητη:\n");
		ka.setDepartment(reader.next());
		
		System.out.print("###########################\n");
		//System.out.print("Συνολο εγγεγραμμενων User:\n");
		//System.out.print(ka.getUsersCounter()+"\n");
		System.out.print("ΑΜ εγγραμμενου Φοιτητη:\n");
		System.out.print(ka.getRegistrationNumber()+"\n");
		System.out.print("Username εγγραμμενου Φοιτητη:\n");
		System.out.print(ka.getUsername()+"\n");
		System.out.print("Ονομα εγγραμμενου Φοιτητη:\n");
		System.out.print(ka.getName()+"\n");
		System.out.print("Επιθετο εγγραμμενου Φοιτητη:\n");
		System.out.print(ka.getSurname()+"\n");	
		System.out.print("Τμημα εγγραμενου Φοιτητη:\n");
		System.out.print(ka.getDepartment()+"\n");
		
		
		//Users
		User us=new User();
		System.out.print("Username User:\n");
		us.setUsername(reader.next());
		System.out.print("Ονομα User:\n");	
		us.setName(reader.next());
		System.out.print("Επιθετο User:\n");
		us.setSurname(reader.next());
		System.out.print("Τμημα User:\n");
		us.setDepartment(reader.next());
		
		System.out.print("###########################\n");
		//System.out.print("Συνολο εγγεγραμμενων User:\n");
		//System.out.print(us.getUsersCounter()+"\n");
		System.out.print("Username εγγραμμενου User:\n");
		System.out.print(us.getUsername()+"\n");
		System.out.print("Ονομα εγγραμμενου User:\n");
		System.out.print(us.getName()+"\n");
		System.out.print("Επιθετο εγγραμμενου User:\n");
		System.out.print(us.getSurname()+"\n");	
		System.out.print("Τμημα εγγραμενου User:\n");
		System.out.print(us.getDepartment()+"\n");
		
		
		//Professors
		Professor pr=null;
		ok=false;
		while(!ok){
			try{
				System.out.print("ΑΦΜ Καθηγητη:\n");
				pr=new Professor(reader.nextInt());
				System.out.print("ο Καθηγητης εγγραφθηκε "+"\n");
				ok=true;
			}
			catch(Exception A){
				System.out.print("Λανθασμενο ΑΦΜ\n");
				ok = false;
				reader.nextLine();
				continue;
			}
		}
		System.out.print("Username Καθηγητη:\n");
		
		pr.setUsername(reader.next());
		System.out.print("Ονομα Καθηγητη:\n");	
		pr.setName(reader.next());
		System.out.print("Επιθετο Καθηγητη:\n");
		pr.setSurname(reader.next());
		System.out.print("Τμημα Καθηγητη:\n");
		pr.setDepartment(reader.next());
		
		System.out.print("###########################\n");
		//System.out.print("Συνολο εγγεγραμμενων Καθηγητη:\n");
		//System.out.print(pr.getUsersCounter()+"\n");
		System.out.print("Username εγγραμμενου Καθηγητη:\n");
		System.out.print(pr.getUsername()+"\n");
		System.out.print("Ονομα εγγραμμενου Καθηγητη:\n");
		System.out.print(pr.getName()+"\n");
		System.out.print("Επιθετο εγγραμμενου Καθηγητη:\n");
		System.out.print(pr.getSurname()+"\n");	
		System.out.print("Τμημα εγγραμενου Καθηγητη:\n");
		System.out.print(pr.getDepartment()+"\n");
		
		
		
		
		
		boolean flag=false;
		while(!flag){
		try {
			System.out.print("Παρακαλω εισαγετε την διευθυνση του αρχειου για εισαγωγη δεδομενων:\n");
			reader=new Scanner(new File(reader.next())).useDelimiter("[,\n]"); //split by ,
			flag=true;
		} catch (FileNotFoundException e) {
			flag=false;
			System.out.print("Λανθασμενη διευθυνση \n");
			reader.nextLine();
			continue;
		}
		}
		reader.nextLine();//Στη πρώτη γραμμή έχει τα ονόματα των στηλών, αρα το προσπερνάμε
		Student tempStud=null;
		//int j=0;
		while (reader.hasNextLine()){
			if(reader.hasNext()) {
		        try{
	        	tempStud=new Student(Integer.parseInt(reader.next()));//Ο constructor έχει μόνο το ΑΜ
	        	tempStud.setUsername(reader.next());
	        	tempStud.setName(reader.next());
	        	tempStud.setSurname(reader.next());
	        	tempStud.setDepartment(reader.next());
				s.enlistStudent(tempStud);
		        }
		        catch(Exception a){
		        	System.out.print("Λανθασμενα δεδομενα");
		        }
			}
		}
	}
}