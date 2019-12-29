package project1.data;
/* Data Structures & Algorithms
 * Project I
 * Robert Kulesza
 * October 14, 2018
 */ 

public class Student implements Comparable<Student> {
	public String firstname = null, lastname = null;
	public Birthdate birthdate = null;
	
	public Student() { }
	public Student(String fname, String lname, Birthdate bday) { firstname = fname; lastname = lname; birthdate = bday;}
	
	public String toString() {
		return firstname+" "+lastname;
	}
	
	@Override
	public int compareTo(Student arg0) {
		int comparison = birthdate.compareTo(arg0.birthdate);
		if(comparison == 0) comparison = lastname.compareTo(arg0.lastname);
		if(comparison == 0) comparison = firstname.compareTo(arg0.firstname);
		return comparison;
	}
}
