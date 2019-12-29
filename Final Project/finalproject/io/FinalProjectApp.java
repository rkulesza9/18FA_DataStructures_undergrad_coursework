package finalproject.io;

import java.io.File;
import java.util.ArrayList;

import finalproject.data.Movie;
import finalproject.util.UserQueryType;
import homework5.MyPriorityQueue;

public class FinalProjectApp {
	
	private static File input = new File("io_projectf/input.txt");
	public static void console() {
		ArrayList<Movie> movies = FinalProjectInput.load(input);
		
		boolean exit = false;
		while(!exit) {
			System.out.println("The following are queries you can make about the movies. Type the number in the brackets and press space/enter in order to execute a query.");
			System.out.printf("[%s] %s\n[%s] %s\n[%s] %s\n[%s] %s\n[%s] %s",0,"Highest Percentage",
																	 1, "Most Viewed",
																	 2, "Highest Rating",
																	 3, "Latest Movie",
																	 4, "exit");
			System.out.print("\nawaiting input: ");
			int input = FinalProjectInput.keyboard.nextInt();
			boolean max;
			int size;
			MyPriorityQueue<Movie> mpq;
			
			switch(input) {
			case 0:
				System.out.println("Do you want to search for the maximum or minimum? (M = maximum, m = minimum): ");
				max = FinalProjectInput.keyboard.next().equals("M");
				System.out.println("How large would you like the list: ");
				size = FinalProjectInput.keyboard.nextInt();
				mpq = FinalProjectInput.pq(movies,UserQueryType.HIGHEST_PERCENTAGE,max);
				System.out.println("output: ");
				for(int x = 0; x < size; x++) {
					System.out.println("\t"+mpq.poll());
				}
				break;
			case 1:
				System.out.println("Do you want to search for the maximum or minimum? (M = maximum, m = minimum): ");
				max = FinalProjectInput.keyboard.next().equals("M");
				System.out.println("How large would you like the list: ");
				size = FinalProjectInput.keyboard.nextInt();
				mpq = FinalProjectInput.pq(movies,UserQueryType.MOST_VIEWED,max);
				System.out.println("output: ");
				for(int x = 0; x < size; x++) {
					System.out.println("\t"+mpq.poll());
				}
				break;
			case 2:
				System.out.println("Do you want to search for the maximum or minimum? (M = maximum, m = minimum): ");
				max = FinalProjectInput.keyboard.next().equals("M");
				System.out.println("How large would you like the list: ");
				size = FinalProjectInput.keyboard.nextInt();
				mpq = FinalProjectInput.pq(movies,UserQueryType.HIGHEST_RATING,max);
				System.out.println("output: ");
				for(int x = 0; x < size; x++) {
					System.out.println("\t"+mpq.poll());
				}
				break;
			case 3:
				System.out.println("Do you want to search for the maximum or minimum? (M = maximum, m = minimum): ");
				max = FinalProjectInput.keyboard.next().equals("M");
				System.out.println("How large would you like the list: ");
				size = FinalProjectInput.keyboard.nextInt();
				mpq = FinalProjectInput.pq(movies,UserQueryType.LATEST_MOVIE,max);
				System.out.println("output: ");
				for(int x = 0; x < size; x++) {
					System.out.println("\t"+mpq.poll());
				}
				break;
			case 4:
				System.out.println("program exited");
				return;
			}
			
			System.out.println("\n");
		}
		
	}

}
