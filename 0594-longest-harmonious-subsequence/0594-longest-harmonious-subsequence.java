import java.util.HashMap;
import java.util.Map;

class Solution {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        int maxLength = 0;
        for (int num : freqMap.keySet()) {
            if (freqMap.containsKey(num + 1)) {
                maxLength = Math.max(maxLength, freqMap.get(num) + freqMap.get(num + 1));
            }
        }
        return maxLength;
    }
}