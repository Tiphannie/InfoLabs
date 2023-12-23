package combinations;

import java.util.ArrayList;
import java.util.List;

public class SubstringGenerator {
    private String characters;
    private int[] charCount;

    public SubstringGenerator(String characters) {
        this.characters = characters;
        this.charCount = countCharacterOccurrences(characters);
    }

    public List<String> generateSubstrings() {
        List<String> substrings = new ArrayList<>();
        backtrack(0, new StringBuilder(), substrings);
        return substrings;
    }

    private void backtrack(int start, StringBuilder current, List<String> substrings) {
        substrings.add(current.toString());

        for (int i = start; i < characters.length(); i++) {
            char currentChar = characters.charAt(i);
            int count = charCount[currentChar - 'A'];

            if (count > 0) {
                charCount[currentChar - 'A']--;
                current.append(currentChar);
                backtrack(i, current, substrings);
                current.deleteCharAt(current.length() - 1);
                charCount[currentChar - 'A']++;
            }
        }
    }

    
    private int[] countCharacterOccurrences(String characters) {
        int[] count = new int[26]; // Assuming characters are uppercase English alphabets

        for (char c : characters.toCharArray()) {
            count[c - 'A']++;
        }
        
        return count;
    }

    public static void main(String[] args) {
        String input = "JAVA";
        SubstringGenerator generator = new SubstringGenerator(input);
        List<String> substrings = generator.generateSubstrings();

        System.out.println("All substrings from " + input + ":");
        for (String substring : substrings) {
            System.out.println(substring);
        }
    }
}