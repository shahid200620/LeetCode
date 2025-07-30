class Solution {
    public int longestSubarray(int[] nums) {
        int maxVal = 0;
        for (int num : nums) {
            if (num > maxVal) {
                maxVal = num;
            }
        }

        int maxLength = 0;
        int currentLength = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == maxVal) {
                currentLength++;
            } else {
                maxLength = Math.max(maxLength, currentLength);
                currentLength = 0;
            }
        }
        
        maxLength = Math.max(maxLength, currentLength);
        
        return maxLength;
    }
}