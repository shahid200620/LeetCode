class Solution {
    public int longestSubsequence(String s, int k) {
        int n = s.length();
        int resultLength = 0;
        long currentNumber = 0;
        int power = 0;

        for (char c : s.toCharArray()) {
            if (c == '0') {
                resultLength++;
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '1') {
                if (power < 63 && (currentNumber + (1L << power)) <= k) {
                    currentNumber += (1L << power);
                    resultLength++;
                } else {
                    break;
                }
            }
            power++;
        }
        
        return resultLength;
    }
}