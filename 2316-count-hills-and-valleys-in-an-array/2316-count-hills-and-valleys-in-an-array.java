import java.util.ArrayList;
import java.util.List;

class Solution {
    public int countHillValley(int[] nums) {
        List<Integer> distinctNums = new ArrayList<>();
        distinctNums.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                distinctNums.add(nums[i]);
            }
        }

        int count = 0;
        if (distinctNums.size() < 3) {
            return 0;
        }

        for (int i = 1; i < distinctNums.size() - 1; i++) {
            int left = distinctNums.get(i - 1);
            int current = distinctNums.get(i);
            int right = distinctNums.get(i + 1);

            if (current > left && current > right) {
                count++;
            } else if (current < left && current < right) {
                count++;
            }
        }

        return count;
    }
}