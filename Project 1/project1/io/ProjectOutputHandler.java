package project1.io;
/* Data Structures & Algorithms
 * Project I
 * Robert Kulesza
 * October 14, 2018
 */ 

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Queue;

import project1.data.*;

public class ProjectOutputHandler {
	private File file;
	/*Class #c:\n (where c is the class number)
	 * FIRST2 LAST2 has the closest birthday to FIRST LAST. (on last: \n)
	 * 
	 * students should be sorted:
	 * 		by birthdate, ignoring year
	 * 		same birthdate --> use first name
	 * 
	 * (blank line between each case)
	 * 
	 * if person before and after querried person has same bday distance
	 * 		choose AFTER
	 * 
	 * 
	 */
	
	public ProjectOutputHandler(String filename) {
		try{
			file = new File(filename);
		}catch(Exception e) {
			e.printStackTrace();
			file = null;
		}
	}

	public void save(List<Classroom> classes) {
		try {
			FileWriter writer = new FileWriter(file);
			writer.write("");
			for(int x = 0; x < classes.size(); x++) {
				if(x > 0) writer.append("\n");
				writer.append("Class #"+(x+1)+":\n\n");
				writer.append(classes.get(x).toString());
				if(x < classes.size()-1) writer.append("\n");
			}
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
