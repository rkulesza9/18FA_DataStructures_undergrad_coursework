package Leetcode04;
import java.util.Arrays;
import java.util.Random;

public class HardProblem1 {
	
	/*THE PROBLEM (MEDIAN OF TWO ARRAYS)
	 * There are two sorted arrays nums1 and nums2 of size m and n respectively.

		Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

		You may assume nums1 and nums2 cannot be both empty.
	 */

	public static void main(String[] args) {
		
		Random r = new Random();
		int[] arr1 = new int[r.nextInt(15)],
			  arr2 = new int[r.nextInt(15)];
		
		for(int x = 0; x < arr1.length; x++) {
			arr1[x] = r.nextInt(100);
		}
		for(int x = 0; x < arr2.length; x++) {
			arr2[x] = r.nextInt(100);
		}
		
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		
		System.out.printf("arr1 = %s\narr2 = %s\n\nmedian: %s",Arrays.toString(arr1),Arrays.toString(arr2),findMedian(arr1,arr2));
		
	}
	
	public static double findMedian(int[] nums1,int[] nums2) {
		int mindex =  (nums1.length + nums2.length)/2;
		boolean iseven = (nums2.length + nums1.length) %2 == 0;
		int index1 = 0, index2 = 0, bothindex = -1;
		double soln = 0, soln2 = 0;
		
		while(index1 < nums1.length && index2 < nums2.length && bothindex < mindex) {
			bothindex++;
			if(nums1[index1] < nums2[index2]) {
				soln = nums1[index1];
				if(iseven && bothindex == mindex-1) soln2 = nums1[index1];
				index1++;
			} else {
				soln = nums2[index2];
				if(iseven && bothindex == mindex-1) soln2 = nums2[index2];
				index2++;
			}
		}
		
		while(index1 < nums1.length && bothindex < mindex) {
			bothindex++;
			soln = nums1[index1];
			if(iseven && bothindex == mindex-1) soln2 = nums1[index1];
			index1++;
			
		}
		
		while(index2 < nums2.length && bothindex < mindex) {
			bothindex++;
			soln = nums2[index2];
			if(iseven && bothindex == mindex-1) soln2 = nums2[index2];
			index2++;
		}
		
		if(iseven) return (soln + soln2)/2;
		return soln;
		
	}

}
