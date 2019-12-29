package project2;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import homework6.MyHashMap;

public class MostHomophones {
	
	public static String output = "";
	
	public static void main(String[]args) {
		long start = System.nanoTime();
		MyHashMap<String,ArrayList<String>> dictionary = new MyHashMap<String,ArrayList<String>>();
		ArrayList<String> wordsounds = new ArrayList<String>();
		
		load("io_project2/project2-input.txt",dictionary,wordsounds);
		
		/*int max = -1;
		String maxSound = "";
		for(String sound : wordsounds) {
			if(dictionary.get(sound).size() > max) {
				max = dictionary.get(sound).size();
				maxSound = sound;
			}
		}*
		ArrayList<String> maxWords = dictionary.get(maxSound);
		
		outputln(max);
		for(String s : maxWords) outputln(s);
		outputln("TOTAL TIME: "+TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - start));*/
		
		PriorityQueue<String> heap = new PriorityQueue<String>(new Comparator<String>() {

			@Override
			public int compare(String arg0, String arg1) {
				return dictionary.get(arg1).size() - dictionary.get(arg0).size();
			}
			
		});
		
		for(String str : wordsounds) heap.offer(str);
		String maxKey = heap.poll();
		ArrayList<String> maxList = dictionary.get(maxKey);
		int max = maxList.size();
		
		while(maxList.size() == max) {
			outputln(max);
			for(String str : maxList) {
				outputln(str);
			}
			outputln("");

			maxKey = heap.poll();
			maxList = dictionary.get(maxKey);
		}
		
		saveOutput("io_project2/project2-output.txt");
	}

	private static void load(String string, MyHashMap<String, ArrayList<String>> dictionary, ArrayList<String> wordsounds) {
		try {
			File file = new File(string);
			Scanner reader = new Scanner(file);
			while(reader.hasNext()) {
				String word = reader.next();
				String sound = reader.nextLine();
				if(dictionary.get(sound) == null) {
					dictionary.put(sound, new ArrayList<String>());
					wordsounds.add(sound);
				}
				dictionary.get(sound).add(word);
			}
			reader.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void outputln(Object l){ output += l + "\n"; }
	private static void saveOutput(String outputFileName) {
		try {
			FileWriter writer = new FileWriter(outputFileName);
			writer.write(output);
			writer.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
