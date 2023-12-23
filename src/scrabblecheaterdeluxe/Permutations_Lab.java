package scrabblecheaterdeluxe;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Permutations_Lab {
	
    public List<String> generateKPermutations(String s, int k) {
        List<String> result = new ArrayList<>();
        generateCombinations(s, k, 0, "", result);
        return result;
    }

    private void generateCombinations(String s, int k, int start, String current, List<String> result) {
        if (current.length() == k) {
            result.add(current);
            return;
        }

        for (int i = start; i < s.length(); i++) {
            char letter = s.charAt(i);
            generateCombinations(s, k, i + 1, current + letter, result);
        }
    }
    
    public HashSet<String> makePermutations(String s) {
    	  int k = s.length();
    	  Dictionary dict = new Dictionary();
          HashSet<String> set = new HashSet<>();
          for(int i = 2; i <= k; i++) {
          	List<String> kPermutations = generateKPermutations(s, i);
          	for (String combination : kPermutations) {
          		set.add(dict.normalize(combination));
          	}
          }
          return set;
    }

    public static void main(String[] args) {
    	Permutations_Lab perm = new Permutations_Lab();
        String s = "java";
        System.out.print(perm.makePermutations(s));
    }
}
