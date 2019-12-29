package Leetcode354;

import java.util.ArrayList;
import java.util.Arrays;

public class Leetcode354 {
	
	/*
	 * int[] branches
	 * 
	 */
	public static int maxEnvelopes(int[][] envelopes) {
        sort(envelopes);
        
        ArrayList<int[]> chosen = new ArrayList<int[]>();
        ArrayList<Integer> counts = new ArrayList<Integer>();
        
        chosen.add(envelopes[0]);
        counts.add(1);
        for(int x = 0; x < envelopes.length; x++){
        	int[] envelope = envelopes[x];
        	for(int y = 0; y < chosen.size(); y++) {
        		int[] choice = chosen.get(y);
        		if(envelope[0] < choice[0]) {
        			if(envelope[1] < choice[1]) {
        				chosen.set(y, envelope);
        				counts.set(y, counts.get(y)+1);
        			}
        			else{
        				chosen.add(envelope);
        				counts.add(1);
        			}
        		}
        	}
        }
        
        int max = 0;
        for(int x = 0; x < counts.size(); x++) {
        	if(counts.get(x) > max) max = counts.get(x);
        }
        
        for(int[] a : chosen) System.out.print(Arrays.toString(a)+" ");
        System.out.println("\n"+counts);
        return max;
	}
	
	private static void sort(int[][] envelopes) {
		mergeSort(envelopes,0,envelopes.length-1);
	}
	
	public static void mergeSort(int[][] numbers,int start,int end) {
		if(start < end) {
			mergeSort(numbers,start,start+(end-start)/2);
			mergeSort(numbers,start+(end-start)/2 +1,end);
			merge(numbers,start,start+(end-start)/2,end);
		}
	}
	private static void merge(int[][] arr,int grp1start,int grp1end,int grp2end) {
		int[][] grp1 = new int[grp1end - grp1start + 1][2],
			  grp2 = new int[grp2end - grp1end][2];
		int index1 = 0, index2 = 0, mindex = grp1start;
		
		for(int x = 0; x < grp1.length; x++) {
			grp1[x] = arr[grp1start + x];
		}
		for(int x = 0; x < grp2.length; x++) {
			grp2[x] = arr[(grp1end+1+x)];
		}
		
		while(index1 < grp1.length && index2 < grp2.length) {

			if(compare(grp1[index1],grp2[index2])) {
				arr[mindex] = grp1[index1];
				index1++;
			}else{
				arr[mindex] = grp2[index2];
				index2++;
			}
			mindex++;
		}
		
		while(index1 < grp1.length) {
			arr[mindex] = grp1[index1];
			mindex++;
			index1++;
		}
		
		while(index2 < grp2.length) {
			arr[mindex] = grp2[index2];
			mindex++;
			index2++;
		}
	}

	private static boolean compare(int[] is, int[] is2) {
		if(is[0] > is2[0]) return true;
		if(is[0] == is2[0] && is[1] > is2[1]) return true;
		return false;
	}

	public static void main(String[]args) {
		int[][] a = new int[][] { new int[] {5,7}, new int[] {6,7}, new int[] {6,4}, new int[] {2,3}, new int[] {1,1}};
		System.out.println(maxEnvelopes(a));
	}
}
