package scrabblecheaterdeluxe;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		Dictionary dict = new Dictionary();
		if(dict.load()) {
			System.out.println("successfully loaded");
		}
		System.out.println("Entries loaded: " + dict.size());
		System.out.println("Collisions: " + dict.getNumberOfCollisions());
		System.out.println("Longest chain: " + dict.getLongestChain());
		dict.lookup("reser");
//		dict.printAll();
//		dict.printCollisions();
//		dict.printOnlyPermutations("reserev");

	}

}
