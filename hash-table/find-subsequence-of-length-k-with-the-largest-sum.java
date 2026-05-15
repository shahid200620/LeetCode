// import java.util.Arrays;
// import java.util.PriorityQueue;
// import java.util.Comparator;
// import java.util.HashMap;
class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        
        for (int i = 0; i < nums.length; i++) {
            pq.offer(new int[]{nums[i], i});
            if (pq.size() > k) {
                pq.poll();
            }
        }
        
        HashMap<Integer, Integer> indicesToKeep = new HashMap<>();
        while (!pq.isEmpty()) {
            int[] pair = pq.poll();
            indicesToKeep.put(pair[1], pair[0]);
        }
        
        int[] result = new int[k];
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (indicesToKeep.containsKey(i)) {
                result[count++] = nums[i];
                indicesToKeep.remove(i); 
                if (count == k) {
                    break;
                }
            }
        }
        
        return result;
    }
}