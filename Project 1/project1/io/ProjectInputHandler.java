package project1.io;
/* Data Structures & Algorithms
 * Project I
 * Robert Kulesza
 * October 14, 2018
 */ 

import java.io.File;  
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import project1.data.*;

public class ProjectInputHandler {
	
	private File file;
	
	/*	k [# students in the class]
	 * 	next k lines:
	 * 		firstname lastname month day yob
	 * 		[no 2 people have same name]
	 * m [# of queries for the class]
	 * next m lines:
	 * 		firstname lastname [what is the student with the closest bday]
	 */
	
	public ProjectInputHandler(String filename) {
		try{
			file = new File(filename);
		}catch(Exception e) {
			e.printStackTrace();
			file = null;
		}
	}
	
	//assuming classes is initialized and empty
	public void load(ArrayList<Classroom> classes) {
		try {
			Scanner scanner = new Scanner(file);
			classes.ensureCapacity(scanner.nextInt());
			scanner.nextLine();
			
			while(scanner.hasNextLine()) {
				int numStudents = scanner.nextInt();
				scanner.nextLine(); // to capture line
				Classroom room = new Classroom();
				room.ensureCapacityStudents(numStudents);
				Birthdate.Reference ref= new Birthdate.Reference();
				for(int x = 0; x < numStudents; x++) {
					Student s = new Student();
					s.firstname = scanner.next();
					s.lastname = scanner.next();
					String month = scanner.next();
					int day = scanner.nextInt();
					if(month.equals("FEBRUARY") && day == 29) ref.setLeapYear(true);
					s.birthdate = new Birthdate(ref,month,day);
					
					scanner.nextInt(); //throw away year
					
					scanner.nextLine(); //to capture line
					room.addStudent(s);
				}
				
				int numQueries = scanner.nextInt();
				room.ensureCapacityQueries(numQueries);
				scanner.nextLine(); // extra line end
				for(int x = 0; x < numQueries; x++) {
					Query q = new Query(scanner.next(),scanner.next());
					
					if(scanner.hasNextLine()) scanner.nextLine(); //clear line end
					room.addQuery(q);
				}
				
				classes.add(room);
			}
			
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
