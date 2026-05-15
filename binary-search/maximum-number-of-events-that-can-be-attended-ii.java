import java.util.Arrays;

public class Solution {
    public int maxValue(int[][] events, int k) {
        Arrays.sort(events, (a, b) -> Integer.compare(a[1], b[1]));
        int n = events.length;
        int[][] dp = new int[k + 1][n + 1];

        for (int i = 1; i <= k; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i][j - 1];
                int l = binarySearch(events, j - 1, events[j - 1][0]);
                dp[i][j] = Math.max(dp[i][j], dp[i - 1][l] + events[j - 1][2]);
            }
        }
        return dp[k][n];
    }

    private int binarySearch(int[][] events, int right, int start) {
        int left = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (events[mid][1] < start) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
