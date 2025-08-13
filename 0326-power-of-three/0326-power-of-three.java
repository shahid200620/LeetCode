class Solution {
    public boolean isPowerOfThree(int n) {
        if (n <= 0) {
            return false;
        }
        
        int largestPowerOfThree = 1162261467;
        return largestPowerOfThree % n == 0;
    }
}