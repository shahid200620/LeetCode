class Solution {
    public int possibleStringCount(String word) {
        if (word == null || word.isEmpty()) {
            return 0;
        }

        int count = 1;
        int n = word.length();

        for (int i = 0; i < n; ) {
            char currentChar = word.charAt(i);
            int j = i;
            while (j < n && word.charAt(j) == currentChar) {
                j++;
            }
            int runLength = j - i;
            if (runLength > 1) {
                count += (runLength - 1);
            }
            i = j;
        }

        return count;
    }
}