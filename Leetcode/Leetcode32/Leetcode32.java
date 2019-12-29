package Leetcode32;

import java.util.Stack;

//make more efficient
public class Leetcode32 {
	
	public static void main(String[]args) {
		System.out.println(longestValidParentheses(")()())()()("));
		
	}
	
    public static int longestValidParentheses(String str) {
    	if(str.length() < 2) return 0;
    	int maxlength = 0;
    	while(str.length() > 0) {
    		int index = isValid(str);
    		if(index == -1) {
    			if(str.length() > maxlength) maxlength = str.length();
    			break;
    		} else {
    			String good = str.substring(0,index);
    			if(good.length() > maxlength) maxlength = good.length();
    			str = str.substring(index+1,str.length());
    		}
    	}
    	return maxlength;
    }
    
    /**
     * 
     * @param s
     * @return index of fisrt perenteces that makes the expression invalid
     * 			-1 if the string is valid
     */
    public static int isValid(String str) {
    	int counter = 0;
		int c = 0; //count lefthand error
		boolean recordnext = false;
		
		for(int x = 0; x < str.length(); x++) {
			if(counter == 0) recordnext = true;
			if(str.charAt(x) == '(') {
				counter++;
				if(recordnext) {
					c = x;
					recordnext = false;
				}
			}
			if(str.charAt(x) == ')') {
				if(counter == 0) return x; //too many )
				counter--;
			}
		}
		
		//too many (
		if(counter > 0) return c;
		
		return -1;
		
	}

}
