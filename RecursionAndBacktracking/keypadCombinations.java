
package leetCode.RecursionAndBacktracking;
import java.util.*;
// Given a string containing digits from 2-9 inclusive, print all possible letter combinations that the number could represent. You can print the answer in any order. A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

// For example, if the input is "23," the output should be "ad," "ae," "af," "bd," "be," "bf," "cd," "ce," "cf." If the input is "2," the output should be "a," "b," "c." If the input is an empty string, the output should be an empty string.

import java.util.ArrayList;
import java.util.List;

public class keypadCombinations {

    // Mapping of digits to their corresponding letters.
    private static final String[] KEYPAD = {
        "0",    // 0 maps to "0"
        "",     // 1 has no mapping
        "abc",  // 2
        "def",  // 3
        "ghi",  // 4
        "jkl",  // 5
        "mno",  // 6
        "pqrs", // 7
        "tuv",  // 8
        "wxyz", // 9
        "*",    // * maps to "*"
        "#"     // # maps to "#"
    };

    public static List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return combinations; // Return empty list for empty input
        }
        
        backtrack(combinations, digits, "", 0);
        return combinations;
    }

    private static void backtrack(List<String> combinations, String digits, String current, int index) {
        // Base case: if the current combination length matches the digits length
        if (index == digits.length()) {
            combinations.add(current);
            return;
        }
        
        char digit = digits.charAt(index);
        String letters = KEYPAD[digit - '0'];
        
        for (char letter : letters.toCharArray()) {
            backtrack(combinations, digits, current + letter, index + 1);
        }
    }

    public static void main(String[] args) {
        // Sample Inputs
        String digits1 = "203*9";
        String digits2 = "2#0";
        String digits3 = "";

        // Sample Outputs
        System.out.println(letterCombinations(digits1)); // ["a0d*w", "a0d*x", "a0d*y", ..., "c0f*z"]
        System.out.println(letterCombinations(digits2)); // ["a#0", "b#0", "c#0"]
        System.out.println(letterCombinations(digits3)); // []
    }
}
