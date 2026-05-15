import java.util.PriorityQueue;

class Solution {
    public long minimumDifference(int[] nums) {
        int n = nums.length / 3;

        long[] minLeftSum = new long[nums.length];
        PriorityQueue<Integer> pqLeft = new PriorityQueue<>((a, b) -> b - a);
        long currentLeftSum = 0;

        for (int i = 0; i < 2 * n; i++) {
            currentLeftSum += nums[i];
            pqLeft.offer(nums[i]);
            if (pqLeft.size() > n) {
                currentLeftSum -= pqLeft.poll();
            }
            if (pqLeft.size() == n) {
                minLeftSum[i] = currentLeftSum;
            } else {
                minLeftSum[i] = Long.MAX_VALUE;
            }
        }

        long[] maxRightSum = new long[nums.length];
        PriorityQueue<Integer> pqRight = new PriorityQueue<>();
        long currentRightSum = 0;

        for (int i = nums.length - 1; i >= n; i--) {
            currentRightSum += nums[i];
            pqRight.offer(nums[i]);
            if (pqRight.size() > n) {
                currentRightSum -= pqRight.poll();
            }
            if (pqRight.size() == n) {
                maxRightSum[i] = currentRightSum;
            } else {
                maxRightSum[i] = Long.MIN_VALUE;
            }
        }

        long minDiff = Long.MAX_VALUE;

        for (int i = n - 1; i < 2 * n; i++) {
            if (minLeftSum[i] != Long.MAX_VALUE && maxRightSum[i + 1] != Long.MIN_VALUE) {
                minDiff = Math.min(minDiff, minLeftSum[i] - maxRightSum[i + 1]);
            }
        }

        return minDiff;
    }
}
