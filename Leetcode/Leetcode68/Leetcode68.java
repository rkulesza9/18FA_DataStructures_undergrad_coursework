package Leetcode68;

import java.util.ArrayList;
import java.util.List;

public class Leetcode68 {

	public static void main(String[]args) {
		List<String> text = fullJustify(new String[] {"This","is","an","example","of","text","justification"},16);
		System.out.println(text);
		for(String str : text) {
			System.out.println("\t|"+str+"|");
		}
	}
	public static List<String> fullJustify(String[]words,int maxWidth) {
		/*
		 * cycle through words, when it gets close to maxWidth end line.
		 * (consider minimum number of spaces)
		 * 
		 * add (maxWidth - realWidth) spaces in the following way:
		 * 			* add space to leftside
		 * 			* add space to rghtside
		 * until no more spaces are left.
		 */
		
		ArrayList<String> solution = new ArrayList<String>();
		String str = "";
		int currlength = -2; //no space with first or last word
		for(int x = 0; x < words.length; x++) {
			String word = words[x];
			if(currlength + word.length() + 1 >= maxWidth) {
				int extra = maxWidth - currlength;
				if(extra > 0) {
					str = str.trim();
					str = fillExtraSpace(str,maxWidth);
				}
				
				solution.add(str);
				str=word+" ";
				currlength = word.length() + 1 - 2;
			} else {
				currlength += word.length() + 1;
				str+=word+(x < words.length-1 ? " " : "");
			}
		}

		str = str.trim();
		while(maxWidth > str.length()) {
			str+=" ";
		}

		solution.add(str);
		return solution;
	}
    public static String fillExtraSpace(String str,int maxWidth) {
		int index = 0;
        if(str.length() == maxWidth) return str;
		if(!str.contains(" ")) str = str+" ";
		while(maxWidth - str.length() > 0) {
			if(str.charAt(index) == ' ' && (index == str.length()-1 || str.charAt(index+1) != ' ')) {
				str = str.substring(0, index+1)+" "+str.substring(index+1,str.length());
				index++;
			}
			if(index == str.length()-1) {
				index = 0;
			}
			index++;
		}
		return str;
	}
}

