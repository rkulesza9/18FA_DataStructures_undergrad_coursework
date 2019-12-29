package project1;	

	/* Data Structures & Algorithms
	 * Project I
	 * Robert Kulesza
	 * October 14, 2018
	 */
	

import java.util.ArrayList;
import project1.io.*;
import project1.data.*;

public class Project1 {

	public static void main(String[]str) {
		long start = System.nanoTime();
		System.out.println("PROGRAM START: "+start);
		
		ProjectInputHandler input = new ProjectInputHandler("io_project1/input.txt");
		ProjectOutputHandler output = new ProjectOutputHandler("io_project1/output.txt");
		
		ArrayList<Classroom> classes = new ArrayList<Classroom>();
		input.load(classes);
		
		for(Classroom c : classes) {
			c.sort();
			c.executeQueries();
		}
		
		output.save(classes);

		long end = System.nanoTime();
		System.out.println("PROGRAM END: "+end);
		System.out.println("\nTOTAL TIME: "+((end-start)/Math.pow(10, 9)));
	}
	
}
