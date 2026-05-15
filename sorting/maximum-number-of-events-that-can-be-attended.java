import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int count = 0;
        int i = 0;
        int n = events.length;
        
        for (int day = 1; day <= 100000; day++) {
            // Add all events that start on this day
            while (i < n && events[i][0] == day) {
                minHeap.offer(events[i][1]);
                i++;
            }
            
            // Remove events that are already over
            while (!minHeap.isEmpty() && minHeap.peek() < day) {
                minHeap.poll();
            }
            
            // Attend the event that ends earliest
            if (!minHeap.isEmpty()) {
                minHeap.poll();
                count++;
            }
        }
        
        return count;
    }
}
