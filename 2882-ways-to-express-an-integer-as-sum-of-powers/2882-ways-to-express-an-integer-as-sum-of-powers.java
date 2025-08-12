import java.util.Arrays;

class Solution {
    public int numberOfWays(int n, int x) {
        int[] dp = new int[n + 1];
        int mod = 1_000_000_007;
        dp[0] = 1;

        for (int i = 1; ; i++) {
            int power = (int) Math.pow(i, x);
            if (power > n) {
                break;
            }
            for (int j = n; j >= power; j--) {
                dp[j] = (dp[j] + dp[j - power]) % mod;
            }
        }

        return dp[n];
    }
}