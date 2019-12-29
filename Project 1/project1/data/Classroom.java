package project1.data;
/* Data Structures & Algorithms  
 * Project I
 * Robert Kulesza
 * October 14, 2018
 */ 

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue; 

public class Classroom {
	private ArrayList<Student> students;
	private ArrayList<Query> queries;
	
	public Classroom() {
		students = new ArrayList<Student>();
		queries = new ArrayList<Query>();
	}
	
	public void ensureCapacityStudents(int m) {
		students.ensureCapacity(m);
	}
	public void ensureCapacityQueries(int m) {
		students.ensureCapacity(m);
	}
	
	public void addStudent(Student st) {
		students.add(st);
	}
	
	public int indexOf(Student st) {
		for(int x = 0; x < students.size(); x++) {
			if(st.compareTo(students.get(x)) == 0) {
				return x;
			}
		}
		return -1;
	}
	
	public void addQuery(Query q) {
		queries.add(q);
	}
	
	public Student getStudent(int x) {
		return students.get(x);
	}
	
	public int indexOf(String fname,String lname) {
		for(int x = 0; x < students.size(); x++) {
			if(students.get(x).firstname.equals(fname) && students.get(x).lastname.equals(lname)) {
				return x;
			}
		}
		return -1;
	}
	
	public Query getQuery(int x) {
		return queries.get(x);
	}
	
	public int numStudents() { return students.size(); }
	public int numQueries() { return queries.size(); }
	
	//mergesort students
	public void sort() {
		mergeSort(students,0,students.size()-1);
	}
	
	private void mergeSort(ArrayList<Student> students,int start,int end) {
		if(start < end) {
			mergeSort(students,start,start+(end-start)/2);
			mergeSort(students,start+(end-start)/2 +1,end);
			merge(students,start,start+(end-start)/2,end);
		}
	}
	private void merge(ArrayList<Student> arr,int grp1start,int grp1end,int grp2end) {
		Student[] grp1 = new Student[grp1end - grp1start + 1],
			  grp2 = new Student[grp2end - grp1end];
		int index1 = 0, index2 = 0, mindex = grp1start;
		
		for(int x = 0; x < grp1.length; x++) {
			grp1[x] = arr.get(grp1start + x);
		}
		for(int x = 0; x < grp2.length; x++) {
			grp2[x] = arr.get(grp1end+1+x);
		}
		
		while(index1 < grp1.length && index2 < grp2.length) {

			if(grp1[index1].compareTo(grp2[index2]) < 0) {
				arr.set(mindex,grp1[index1]);
				index1++;
			}else{
				arr.set(mindex, grp2[index2]);
				index2++;
			}
			mindex++;
		}
		
		while(index1 < grp1.length) {
			arr.set(mindex, grp1[index1]);
			mindex++;
			index1++;
		}
		
		while(index2 < grp2.length) {
			arr.set(mindex, grp2[index2]);
			mindex++;
			index2++;
		}
	}
	
	public void executeQueries() {
		for(Query q : queries) {
			q.execute(this);
		}
	}
	
	//print output for class
	public String toString() {
		String str = "";
		for(int x=0; x < queries.size(); x++) {
			str += queries.get(x) + (x < queries.size()-1 ? "\n":"");
		}
		return str;
	}

}
