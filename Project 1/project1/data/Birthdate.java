package project1.data;
/* Data Structures & Algorithms
 * Project I
 * Robert Kulesza
 * October 14, 2018
 */ 
public class Birthdate implements Comparable<Birthdate> {
	
	 /* PURPOSE FOR CLASS
	 * 	This class represents birth-dates such that they can be compared based on their distances
	 * 		relative to the year.
	 * 	This class is specifically tailored to the provided input format.
	 */
	
	private int month; //the month represented by this Birthdate
	private int day;  //the day represented by this Birthdate
	private Reference ref; //the reference from which this Birthdate can find relevant calendar information
							
	public Birthdate(Reference ref,String m,int d) {
		this.ref = ref;
		setMonth(m);
		setDay(d);
	}
	
	//sets private int month equal to the index of String m in the array of Months in the Reference object ref.
	private void setMonth(String m) {
		for(int x = 0; x < ref.size(); x++) {
			if(m.equals(ref.getMonthStr(x))) {
				month = x;
				return;
			}
		}
	}
	
	public void reset() {
		setMonth(ref.getMonthStr(month));
		setDay(day);
	}
	
	//expects month to already have been set
	//sets private int day equal to d as long as d corresponds to the number of days in the month represented by private month
	private void setDay(int d) {
		if(d == 0) d = 1;
		day = d < ref.getMonthDays(month) ? d : ref.getMonthDays(month);
	}
	
	//getter methods
	public int month() { return month; }
	public int day() { return day; }
	public Reference ref() { return ref; }

	//uses distance between two Birthdates to compare them
	@Override
	public int compareTo(Birthdate o) {
		return ref.numDays(this) - ref.numDays(o);
	}
	
	@Override
	public String toString() {
		return month+"-"+day;
	}
	
	
	
	public static class Reference {
		private Month[] months; //represent the months of the calendar in order
		
		/* PURPOSE OF CLASS
		 * 	Every Birthdate has a reference object from which it obtains the following information:
		 * 		1) how many days are in each month.
		 * 		2) the order of months in the year.
		 */
		
		public Reference() {
			months = new Month[] {new Month("JANUARY",31), new Month("FEBRUARY",28), new Month("MARCH",31), new Month("APRIL",30),
					  new Month("MAY",31), new Month("JUNE",30), new Month("JULY",31), new Month("AUGUST",31),
					  new Month("SEPTEMBER",30), new Month("OCTOBER",31), new Month("NOVEMBER",30), new Month("DECEMBER",31)};
		}
		
		//accessors
		public String getMonthStr(int x) { return months[x].name; }
		public int getMonthDays(int x) { return months[x].days; }
		public int size() { return months.length; }
		
		public int numDays(Birthdate b) {
			int numdays = 0;
			for(int x = 0; x < b.month(); x++) numdays += months[x].days;
			numdays += b.day;
			return numdays;
		}

		public void setLeapYear(boolean on) {
			if(on) months[1].days = 29;
			else months[1].days = 28;
		}
		public boolean isLeapYear() {
			return months[1].days == 29;
		}
		
		public int test(Birthdate b) {
			int numdays = 0;
			for(int x = 0; x < b.month(); x++) {
				System.out.println(numdays);
				numdays+=b.day;
			}
			System.out.println(numdays);
			return numdays;
		}
	
		private static class Month {
			/*PURPOSE OF CLASS
			 * 	represents a month, holding the number of days in that month and the name of that month
			 * 		which for this assignment will always be in all caps
			 */
			public int days = 0; //the number of days in the month
			public String name = ""; //name of the month, complete and in all caps
			public Month(String n, int d) {name = n; days = d;} 
		}	
	}

}
