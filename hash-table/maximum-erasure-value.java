import java.util.HashSet;
import java.util.Set;

class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int left = 0;
        int right = 0;
        int currentSum = 0;
        int maxSum = 0;
        Set<Integer> uniqueElements = new HashSet<>();

        while (right < nums.length) {
            while (uniqueElements.contains(nums[right])) {
                currentSum -= nums[left];
                uniqueElements.remove(nums[left]);
                left++;
            }
            currentSum += nums[right];
            uniqueElements.add(nums[right]);
            maxSum = Math.max(maxSum, currentSum);
            right++;
        }
        return maxSum;
    }
}