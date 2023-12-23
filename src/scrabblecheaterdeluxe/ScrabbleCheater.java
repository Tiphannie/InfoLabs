package scrabblecheaterdeluxe;

import java.io.IOException;
import java.util.Random;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.ArrayList;

public class ScrabbleCheater {

	
	private static Dictionary dict;
	public ScrabbleCheater() throws IOException {
		dict = new Dictionary();
		dict.load();
	}
	
	//to test, input: largely or dealing
	public void findPermutations(String s) {
		ArrayList<String> arrayWords = new ArrayList<>();
		Dictionary.Node[] table = dict.getTable();
		s = dict.normalize(s);
		
			int index = dict.hash(s);
			Dictionary.Node currentNode = table[index];
			while(currentNode != null) {
				String word = currentNode.getWord();
				if(s.equals(dict.normalize(word))) {
					arrayWords.add(word);
				}
				currentNode = currentNode.getNext();
			}
			
		for(String word : arrayWords) {
			System.out.println(word);
		}
//		System.out.println(" " + "x" + " ");
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
	
	private String generate7Letters() {
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		char[] alphabetArray = alphabet.toCharArray();
		String s = "";
		Random random = new Random();
		for(int i = 0; i < 7; i++) {
			int index = random.nextInt(26);
			s += alphabetArray[index];
		}
		return s;
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
		sc.close();
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
//		String s = cheater.prompt7Letters();
//		cheater.findPermutations(cheater.dict.normalize(s));
//		cheater.check();
		
//		String s = cheater.generate7Letters(); 												//generate 7 random letters 
//		System.out.println(s);
		ScrabbleCheater cheater = new ScrabbleCheater();
		String s = "reserve";
		Permutations_Lab perm = new Permutations_Lab();
		HashSet<String> set = new HashSet<>();
		set = perm.makePermutations(s);
		for(String word : set) {
			dict.lookup(word);
		}
	}
	
}
