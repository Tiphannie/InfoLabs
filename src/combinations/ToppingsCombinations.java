package combinations;
import java.util.ArrayList;
import java.util.List;

public class ToppingsCombinations {
    public static List<String> generateCombinations(String string, int k) {
        List<String> combinations = new ArrayList<>();
        backtrack(string, k, 0, "", combinations);
        return combinations;
    }

    private static void backtrack(String string, int k, int start, String current, List<String> combinations) {
        if (k == 0) {
            combinations.add(current);
            return;
        }

        for (int i = start; i < string.length(); i++) {
            String newCombination = current + string.charAt(i);
            backtrack(string, k - 1, i + 1, newCombination, combinations);
        }
    }

    public static void main(String[] args) {
        String toppings = "java";
        int k = 4;

        List<String> combinations = generateCombinations(toppings, k);

        System.out.println("All " + k + "-topping combinations:");
        for (String combination : combinations) {
            System.out.println(combination);
        }
    }
}