package project1;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Check {
	
	public static void main(String[]args) {
		ArrayList<ArrayList<String>> mydata = read("io_project1/output.txt");
		ArrayList<ArrayList<String>> solution = read("io_project1/solutions.txt");

		if(mydata.size() != solution.size()) {
			pln("too few OR too many classes in output");
			return;
		}
		
		for(int x = 0; x < solution.size(); x++) {
			if(solution.get(x).size() != mydata.get(x).size()) {
				pln("too few OR too many queries in Class "+(x+1));
				return;
			}
			pln("Class "+(x+1)+": ");
			for(int y = 0; y < solution.get(x).size(); y++) {
				if(!solution.get(x).get(y).equals(mydata.get(x).get(y))) {
					pln(mydata.get(x).get(y));
					pln("\t"+solution.get(x).get(y));
				}
			}
			pln("");
		}
		
	}

	
	private static ArrayList<ArrayList<String>> read(String string) {
		ArrayList<ArrayList<String>> output = new ArrayList<ArrayList<String>>();
		try {
			File file = new File(string);
			Scanner reader = new Scanner(file);
			
			ArrayList<String> queries = null;
			while(reader.hasNextLine()) {
				String next = reader.nextLine();
				if(next.toLowerCase().contains("class")) {
					queries = new ArrayList<String>();
					output.add(queries);
				} else {
					queries.add(next);
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return output;
	}


	public static void pln(String s) { System.out.println(s); }
	public static void p(String s) { System.out.print(s); }
}
