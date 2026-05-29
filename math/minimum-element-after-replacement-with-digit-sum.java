class Solution {

    public int minElement(int[] nums) {
        int ans = 37;
        for (int num : nums) {
            int dig = 0;
            while (num > 0) {
                dig += num % 10;
                num /= 10;
            }
            ans = Math.min(ans, dig);
        }
        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/leethub-v4/bcilpkkbokcopmabingnndookdogmbna