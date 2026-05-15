class Solution {
    public int[] smallestSubarrays(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        
        int[] lastPos = new int[30];

        for (int i = n - 1; i >= 0; i--) {
            for (int bit = 0; bit < 30; bit++) {
                if (((nums[i] >> bit) & 1) == 1) {
                    lastPos[bit] = i;
                }
            }
            
            int furthest_j = i;
            for (int bit = 0; bit < 30; bit++) {
                furthest_j = Math.max(furthest_j, lastPos[bit]);
            }
            
            ans[i] = furthest_j - i + 1;
        }
        
        return ans;
    }
}