import java.util.Stack;

class Solution {
    public int maximumGain(String s, int x, int y) {
        int totalScore = 0;
        String highPriorityPair;
        String lowPriorityPair;
        int highPriorityScore;
        int lowPriorityScore;

        if (x > y) {
            highPriorityPair = "ab";
            lowPriorityPair = "ba";
            highPriorityScore = x;
            lowPriorityScore = y;
        } else {
            highPriorityPair = "ba";
            lowPriorityPair = "ab";
            highPriorityScore = y;
            lowPriorityScore = x;
        }

        StringBuilder sb = new StringBuilder(s);
        
        // First pass: remove high-priority pairs
        Stack<Character> stack1 = new Stack<>();
        for (char c : sb.toString().toCharArray()) {
            if (c == highPriorityPair.charAt(1) && !stack1.isEmpty() && stack1.peek() == highPriorityPair.charAt(0)) {
                stack1.pop();
                totalScore += highPriorityScore;
            } else {
                stack1.push(c);
            }
        }

        // Convert stack1 back to a string for the second pass
        StringBuilder remaining = new StringBuilder();
        while (!stack1.isEmpty()) {
            remaining.append(stack1.pop());
        }
        remaining.reverse();

        // Second pass: remove low-priority pairs
        Stack<Character> stack2 = new Stack<>();
        for (char c : remaining.toString().toCharArray()) {
            if (c == lowPriorityPair.charAt(1) && !stack2.isEmpty() && stack2.peek() == lowPriorityPair.charAt(0)) {
                stack2.pop();
                totalScore += lowPriorityScore;
            } else {
                stack2.push(c);
            }
        }

        return totalScore;
    }
}