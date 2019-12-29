package finalproject.data;

public class Movie {
	
	public long score_pers = -1; //score percentages
	public int seen_movie = -1;
	public double avg_rating_st = -1;
	public String name = null;
	public int release_year = -1;
	
	public Movie() { }
	public Movie(String nm) { name = nm; }
	public Movie(long sp,int sm,int ars,String nm,int ry) {
		score_pers = sp;
		seen_movie = sm;
		avg_rating_st = ars;
		name = nm;
		release_year = ry;
	}
	
	public String toString() {
		return String.format("%s %s %s %s %s", score_pers, seen_movie, avg_rating_st, name, release_year);
	}

}
