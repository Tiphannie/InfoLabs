package scrabblecheaterbasic1;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;

public class ScrabbleCheater {

	
	private Dictionary dict;
	public ScrabbleCheater() throws IOException {
		dict = new Dictionary();
		dict.load();
	}
	
	//to test, input: largely or dealingai
	public void findPermutations(String s) {
		ArrayList<String> arrayWords = new ArrayList<>();
		Dictionary.Node[] table = dict.getTable();
		s = normalize(s);
		
		for(int i = 0; i < dict.getTableSize(); i++) {
			Dictionary.Node currentNode = table[i];
			while(currentNode != null) {
				String word = currentNode.getWord();
				if(s.equals(normalize(word))) {
					arrayWords.add(word);
				}
				currentNode = currentNode.getNext();
			}
		}
		for(String word : arrayWords) {
			System.out.println(word);
		}
//		System.out.println("///////////////////////////////////////////////////");
	}
	
//	public void check() {
//		Dictionary.Node[] table = dict.getTable();
//		for(int i = 0; i < dict.getTableSize(); i++) {
//			Dictionary.Node currentNode = table[i];
//			while(currentNode != null) {
//				String word = currentNode.getWord();
//				findPermutations(word);
//				currentNode = currentNode.getNext();
//			}
//		}
//	}
	
	public String normalize(String s) {
		char[] charArray = s.toCharArray();
		Arrays.sort(charArray);
		return new String(charArray);
	}
	
	private String prompt7Letters() {
		String s = "";
		Scanner sc = new Scanner(System.in);
		do{
			System.out.println("Write 7 letters without space: ");
			s = sc.nextLine();
			
			if(!checkValid(s) || s.length() != 7) {
				System.out.println("invalid input");
			}

		}
		while(s.length() != 7 || !checkValid(s));
		return s.toLowerCase();
	}
	
	private boolean checkValid(String word) {
		for(int i = 0; i < word.length(); i++) {
			if(!Character.isAlphabetic(word.charAt(i))) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		ScrabbleCheater cheater = new ScrabbleCheater();
		String s = cheater.prompt7Letters();
		cheater.findPermutations(cheater.normalize(s));
//		cheater.check();
	}
	
}
