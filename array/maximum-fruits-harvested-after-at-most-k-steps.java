import java.util.Arrays;

class Solution {
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int n = fruits.length;
        long[] preSum = new long[n + 1];
        int[] positions = new int[n];
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + fruits[i][1];
            positions[i] = fruits[i][0];
        }

        long maxFruits = 0;
        int left = 0;

        for (int right = 0; right < n; right++) {
            int rightPos = positions[right];
            
            while (left <= right) {
                int leftPos = positions[left];
                long cost;

                if (startPos >= leftPos && startPos <= rightPos) {
                    long leftDist = (long)startPos - leftPos;
                    long rightDist = (long)rightPos - startPos;
                    cost = Math.min(2 * leftDist + rightDist, 2 * rightDist + leftDist);
                } else if (startPos < leftPos) {
                    cost = (long)rightPos - startPos;
                } else {
                    cost = (long)startPos - leftPos;
                }

                if (cost > k) {
                    left++;
                } else {
                    long currentFruits = preSum[right + 1] - preSum[left];
                    maxFruits = Math.max(maxFruits, currentFruits);
                    break; 
                }
            }
        }
        return (int)maxFruits;
    }
}