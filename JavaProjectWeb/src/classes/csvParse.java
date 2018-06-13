package classes;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import classes.Password;

public class csvParse {

	public static void main(String args[]) throws FileNotFoundException, IOException
	{
		    String file1="/home/neetshonen/Documents/UNIVERSITY/JAVA EE/TABLESCSV/User.csv";
		    String Line;
			BufferedReader br = new BufferedReader(new FileReader(file1));
			while ((Line = br.readLine())!= null){
				String[] data=Line.split(",");
				String userid=data[0];
				String username=data[1];
				String password=data[2];
				String salt=data[3];
				String name=data[4];
				String surname=data[5];
				String department=data[6];
				String user_role=data[7];
				char[] passwordf = password.toCharArray();
				byte[] saltf = salt.getBytes();
				byte[] hash= Password.hash(passwordf, saltf);
				System.out.println(hash.length);
				String hashString = new String(hash);
				System.out.println(userid+","+username+","+hashString+","+salt+","+name+","+surname+","+department+","+user_role);
			}
	}
}
