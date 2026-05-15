class Solution {
    public int maximumLength(int[] nums) {
        int evenEven = 0;
        int oddOdd = 0;
        int evenOdd = 0;
        int oddEven = 0;

        for (int num : nums) {
            if (num % 2 == 0) {
                evenEven++;
                if (oddEven > 0) {
                    evenOdd = Math.max(evenOdd, oddEven + 1);
                } else {
                    evenOdd = Math.max(evenOdd, 1);
                }
            } else {
                oddOdd++;
                if (evenOdd > 0) {
                    oddEven = Math.max(oddEven, evenOdd + 1);
                } else {
                    oddEven = Math.max(oddEven, 1);
                }
            }
        }
        return Math.max(Math.max(evenEven, oddOdd), Math.max(evenOdd, oddEven));
    }
}