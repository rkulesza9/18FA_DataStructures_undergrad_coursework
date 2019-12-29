package finalproject.io;

import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.regex.Pattern;

import finalproject.data.Movie;
import finalproject.util.MovieComparators;
import finalproject.util.UserQueryType;
import homework5.MyPriorityQueue;

public class FinalProjectInput {
	
	public static Scanner keyboard = new Scanner(System.in);
	
	public static ArrayList<Movie> load(File f) {
		ArrayList<Movie> movies = new ArrayList<Movie>();
		try{
			Scanner reader = new Scanner(f);
			while(reader.hasNext()) {
				Movie m = new Movie();
				m.score_pers = reader.nextLong();
				m.seen_movie = reader.nextInt();
				m.avg_rating_st = reader.nextDouble();
				m.name = reader.next();
				while(m.name.charAt(m.name.length()-1) != '"') {
					m.name += " "+reader.next();
				}
				m.release_year = reader.nextInt();
				movies.add(m);
			}
			reader.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return movies;
	}
	
	public static MyPriorityQueue<Movie> pq(ArrayList<Movie> movies,UserQueryType uqt,boolean max){
		Comparator<Movie> comparator = null;
		switch(uqt) {
		case HIGHEST_PERCENTAGE:
			comparator = MovieComparators.score_pers_comp(max);
			break;
		case MOST_VIEWED:
			comparator = MovieComparators.seen_movie_comp(max);
			break;
		case HIGHEST_RATING:
			comparator = MovieComparators.avg_rating_st_comp(max);
			break;
		case LATEST_MOVIE:
			comparator = MovieComparators.release_year_comp(max);
			break;
		default:
			break;
		}
		MyPriorityQueue<Movie> mpq = new MyPriorityQueue<Movie>(comparator);
		
		for(Movie mov : movies) {
			mpq.offer(mov);
		}
		return mpq;
	}

}
