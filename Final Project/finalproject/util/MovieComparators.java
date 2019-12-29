package finalproject.util;

import java.util.Comparator;

import finalproject.data.Movie;

public class MovieComparators {
	
	public static Comparator<Movie> score_pers_comp(boolean maximum) {
		return new Comparator<Movie>() {

			@Override
			public int compare(Movie o1, Movie o2) { //TODO: fix 
				long res = flip(o1.score_pers) - flip(o2.score_pers);
				if(!maximum) res = -1*res;
				return ( res < 0 ? -1: res == 0 ? 0 : 1);
			}
			
			private long flip(long a) {
				long arr[] = new long[10];
				long p = 1;
				for(int x = arr.length-1; x >= 0; x--, p*=10) {
					arr[x] = ((a/p) % 10);
				}
				
				long result = 0;
				p = 1;
				for(int x = 0; x < arr.length; x++, p*=10) {
					result += (arr[x])*p;
				}
				
				return result;
			}
			
		};
	}
	public static Comparator<Movie> seen_movie_comp(boolean maximum) {
		return new Comparator<Movie>() {

			@Override
			public int compare(Movie o1, Movie o2) {
				int x = o1.seen_movie - o2.seen_movie;
				if(!maximum) x *= -1;
				return x;
			}
			
		};
	}	
	public static Comparator<Movie> avg_rating_st_comp(boolean maximum) {
		return new Comparator<Movie>() {

			@Override
			public int compare(Movie o1, Movie o2) {
				double res = (o1.avg_rating_st - o2.avg_rating_st);
				if(!maximum) res *= -1;
				return res > 0 ? 1 : res == 0 ? 0 : -1;
			}
			
		};
	}
	public static Comparator<Movie> release_year_comp(boolean maximum) {
		return new Comparator<Movie>() {

			@Override
			public int compare(Movie o1, Movie o2) {
				int y = o1.release_year - o2.release_year;
				if(!maximum) y *= -1;
				return y;
			}
			
		};
	}

}
