import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    private Map<Character, String> phoneMap;
    private List<String> result;

    public List<String> letterCombinations(String digits) {
        result = new ArrayList<>();
        
        if (digits == null || digits.length() == 0) {
            return result;
        }

        phoneMap = new HashMap<>();
        phoneMap.put('2', "abc");
        phoneMap.put('3', "def");
        phoneMap.put('4', "ghi");
        phoneMap.put('5', "jkl");
        phoneMap.put('6', "mno");
        phoneMap.put('7', "pqrs");
        phoneMap.put('8', "tuv");
        phoneMap.put('9', "wxyz");

        backtrack(digits, 0, new StringBuilder());
        return result;
    }

    private void backtrack(String digits, int index, StringBuilder currentCombination) {
        if (index == digits.length()) {
            result.add(currentCombination.toString());
            return;
        }

        char digit = digits.charAt(index);
        String letters = phoneMap.get(digit);

        for (char letter : letters.toCharArray()) {
            currentCombination.append(letter);
            backtrack(digits, index + 1, currentCombination);
            currentCombination.deleteCharAt(currentCombination.length() - 1);
        }
    }
}