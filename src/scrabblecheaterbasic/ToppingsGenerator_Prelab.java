package scrabblecheaterbasic;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import scrabblecheaterdeluxe.Dictionary;

public class ToppingsGenerator_Prelab {
    public static List<String> generateKToppings(String toppings, int k) {
        List<String> result = new ArrayList<>();
        generateCombinations(toppings, k, 0, "", result);
        return result;
    }

    private static void generateCombinations(String toppings, int k, int start, String current, List<String> result) {
        if (current.length() == k) {
            result.add(current);
            return;
        }

        for (int i = start; i < toppings.length(); i++) {
            char topping = toppings.charAt(i);
            generateCombinations(toppings, k, i + 1, current + topping, result);
        }
    }

    public static void main(String[] args) {
        String toppings = "java";
        Dictionary dict = new Dictionary();
        HashSet<String> set = new HashSet<>();
        for(int i = 2; i < 5; i++) {
        	List<String> kToppings = generateKToppings(toppings, i);
        	for (String combination : kToppings) {
        		set.add(dict.normalize(combination));
        	}
        }
        for(String word : set) {
        	System.out.println(word);
        }
    }
}
