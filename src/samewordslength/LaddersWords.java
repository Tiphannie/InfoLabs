package samewordslength;

public class LaddersWords {
	
    public static boolean ladderWordsCompare(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }

        int countDiff = 0;

        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
            	countDiff++;
            	
                if (countDiff > 1) {
                    return false;
                }
            }
        }

        return countDiff == 1;
    }

    public static void main(String[] args) {
        String word1 = "hello";
        String word2 = "hallo";

        if (ladderWordsCompare(word1, word2)) {
            System.out.println("The words differ by only one letter.");
        } else {
            System.out.println("The words differ by more than one letter.");
        }
    }
}
