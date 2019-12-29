package project1.io;
/* Data Structures & Algorithms
 * Project I
 * Robert Kulesza
 * October 14, 2018
 */ 

import java.util.List;

import project1.data.Classroom;

public class ProjectCOutputHandler {
	
	public ProjectCOutputHandler() {
		
	}
	
	public void save(List<Classroom> classes) {
		for(int x = 0; x < classes.size(); x++) {
			if(x > 0) System.out.println();
			System.out.println("CLASS #"+(x+1)+":\n");
			System.out.print(classes.get(x).toString());
			if(x < classes.size()-1) System.out.println();
		}
	}

}
