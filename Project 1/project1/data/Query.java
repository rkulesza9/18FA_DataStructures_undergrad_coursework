package project1.data;
/* Data Structures & Algorithms
 * Project I
 * Robert Kulesza
 * October 14, 2018
 */ 

public class Query {
	public Student result = null;
	public String firstname = null, lastname = null;
	
	public Query(String firstname,String lastname) {
		this.firstname = firstname;
		this.lastname = lastname;
	}
	
	/*
	 * ASSUME C IS SORTED
	 * 		
	 */
	public Student execute(Classroom c) {
		int index = c.indexOf(firstname,lastname);
		Student before = null, after = null;
		Student subject = c.getStudent(index);
		Birthdate.Reference ref = subject.birthdate.ref();
		int bfadj = 0, afadj = 0;
		if(c.numStudents() < 2) {
			result = subject;
			return result;
		}
		else if(index == 0) {
			after = c.getStudent(1);					//after = student after subject
			before = c.getStudent(c.numStudents()-1);   //before = last student on list (bc curr student = 0)
			if(after.birthdate.compareTo(before.birthdate) != 0) bfadj = (ref.isLeapYear() ? 366 : 365);		//bfadj = #days in year (366ly or 365) this is to calculate the complement of the intervals we have
			//System.out.println("[first]"+subject+" "+before+" "+after);
		}
		else if(index == c.numStudents()-1) {
			before = c.getStudent(c.numStudents()-2);   //before = student before subject
			after = c.getStudent(0);					//after = first student on list (bc cur = last)
			if(after.birthdate.compareTo(before.birthdate) != 0) afadj = (ref.isLeapYear() ? 366 : 365);		//afadj = numdays in year (366ly or 365) this is to calculate the complement of the intervals we have
			//System.out.println("[last]"+subject+" "+before+" "+after);
		}
		else {
			before = c.getStudent(index-1);				//before = student before subj
			after = c.getStudent(index+1);				//after = student after subj
		}
		long beforediff = subject.birthdate.compareTo(before.birthdate) ; //beforediff = difference between before date and subject date
		long afterdiff = after.birthdate.compareTo(subject.birthdate) ;	  //afterdiff = difference between after date and subjecct date	
		
		if(afterdiff < 0) afterdiff *= -1; 				//abs(afterdiff) we want magnitude not direction
		if(beforediff < 0) beforediff *= -1;			//abs(beforediff) we want magnitue not direction

		
		if(bfadj > 0) beforediff = bfadj - beforediff; 	//if we want the complement, calculate complement of (before,subj)
		if(afadj > 0) afterdiff = afadj - afterdiff;    //if we want the complement, calculate complement of (subj,after)
		
		if(beforediff == afterdiff) {
			result = after;
		}else if(beforediff < afterdiff) {
			result = before;
		} else {
			result = after;
		}
		return result;
	}
	
	public String toString() {
		return result+" has the closest birthday to "+firstname+" "+lastname+".";
	}

}
