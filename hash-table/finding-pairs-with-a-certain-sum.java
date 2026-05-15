import java.util.HashMap;
import java.util.Map;

class FindSumPairs {
    private int[] nums1;
    private int[] nums2;
    private Map<Integer, Integer> freq1;
    private Map<Integer, Integer> freq2;

    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        this.freq1 = new HashMap<>();
        this.freq2 = new HashMap<>();

        for (int num : nums1) {
            freq1.put(num, freq1.getOrDefault(num, 0) + 1);
        }

        for (int num : nums2) {
            freq2.put(num, freq2.getOrDefault(num, 0) + 1);
        }
    }

    public void add(int index, int val) {
        int oldVal = nums2[index];

        freq2.put(oldVal, freq2.get(oldVal) - 1);

        if (freq2.get(oldVal) == 0) {
            freq2.remove(oldVal);
        }

        nums2[index] += val;

        int newVal = nums2[index];

        freq2.put(newVal, freq2.getOrDefault(newVal, 0) + 1);
    }

    public int count(int tot) {
        int pairCount = 0;

        for (Map.Entry<Integer, Integer> entry : freq1.entrySet()) {
            int num1 = entry.getKey();
            int freqOfNum1 = entry.getValue();

            int requiredNum2 = tot - num1;

            if (freq2.containsKey(requiredNum2)) {
                pairCount += freqOfNum1 * freq2.get(requiredNum2);
            }
        }
        return pairCount;
    }
}
