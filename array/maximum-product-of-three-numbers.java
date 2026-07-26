class Solution {
    public int maximumProduct(int[] A) {
        Arrays.sort(A);
        int n = A.length;        
        return Math.max(
            A[n - 1] * A[n - 2] * A[n - 3],
            A[n - 1] * A[0] * A[1]
        );
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna