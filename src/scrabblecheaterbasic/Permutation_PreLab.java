package scrabblecheaterbasic;

import java.util.HashSet;

public class Permutation_PreLab {

	static int count;
	private static HashSet<String> set;
	
	public Permutation_PreLab(String s) {
		set = new HashSet<>();
		writePerms("", "java");
	}
	
	public static void writePerms (String prefix, String rest)
	{
			 	int len = rest.length();
			
			 // If rest is empty, we have a permutation, so print it!
			 	if (len == 0) {
			 		count++;
			 		set.add(prefix);
			 	}
			 	else {
			 		for (int i=0; i < len; i++) {
			 			writePerms (prefix + rest.charAt(i),
			 			remove (rest, i));
			 		}
			 	}

	}
	
	 public static String remove (String s, int i)
	  	{
		 // check if string is long enough
		 int len = s.length();
		 if (i >= len || len == 1) return "";
	 
		 if (i == 0) {
	  // i is the first character
			 return s.substring (1);
		 }
		 else {
			 if (i == len-1){
	  // i is the last character
	 // Note that s.substring (i,j) is the string that
	  // begins in position i and extends to j-1. Isn't Java fun!
	 
				 return s.substring (0, len-1);
	  }
			 else {
	  // is is in the middle somewhere
				 return s.substring (0,i) + s.substring(i+1,len);
			 }
		 }
	  }
	 
	 public static void main(String[] args) {
		 String s = "java";
		 Permutation_PreLab perm = new Permutation_PreLab(s);
		 for(String word : perm.set) {
			 System.out.println(word);
		 }
	 }
}
