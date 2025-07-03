class Solution {
    public char kthCharacter(int k) {
        long currentK = k;
        int currentShift = 0;

        while (currentK > 1) {
            long len = 1;
            while (len < currentK) {
                len *= 2;
            }

            if (currentK <= len / 2) {
                
            } else {
                currentK = currentK - len / 2;
                currentShift++;
            }
        }

        return (char) ('a' + (currentShift % 26));
    }
}