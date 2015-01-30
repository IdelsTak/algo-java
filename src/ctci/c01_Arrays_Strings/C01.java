package t01_Arrays_Strings;

import java.util.ArrayList;
import java.util.HashMap;

public class C01 {
	public class Student {
		public Integer getId() {
			return null;
		}
	}
	
	public HashMap<Integer, Student> buildMap(Student[] students){
		HashMap<Integer, Student> map = new HashMap<>();
		for (Student s : students){
			map.put(s.getId(), s);
		}
		return null;
	}
	
	public ArrayList<String> merge(String[] words, String[] more){
		ArrayList<String> list = new ArrayList<>();
		for (String word : words){
			list.add(word);
		}
		for (String word: more){
			list.add(word);
		}
		return list;
	}
	
	public String joinWords(String[] words){
		String sentence = "";
		for(String word : words){
			sentence += word;
		}
		return sentence;
	}
	
	public String joinWords2(String[] words){
		StringBuilder sb = new StringBuilder();
		for(String word : words){
			sb.append(word);
		}
		return sb.toString();
	}
}
