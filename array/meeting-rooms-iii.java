import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);

        long[] roomAvailabilityTime = new long[n];
        int[] meetingCounts = new int[n];

        PriorityQueue<Integer> availableRooms = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            availableRooms.offer(i);
        }

        PriorityQueue<long[]> busyRooms = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) {
                return Long.compare(a[0], b[0]);
            }
            return Integer.compare((int) a[1], (int) b[1]);
        });

        for (int[] meeting : meetings) {
            int start = meeting[0];
            int end = meeting[1];
            long duration = end - start;

            while (!busyRooms.isEmpty() && busyRooms.peek()[0] <= start) {
                availableRooms.offer((int) busyRooms.poll()[1]);
            }

            if (!availableRooms.isEmpty()) {
                int roomIdx = availableRooms.poll();
                meetingCounts[roomIdx]++;
                busyRooms.offer(new long[]{end, roomIdx});
            } else {
                long[] earliestFreeRoom = busyRooms.poll();
                long freeTime = earliestFreeRoom[0];
                int roomIdx = (int) earliestFreeRoom[1];

                meetingCounts[roomIdx]++;
                busyRooms.offer(new long[]{freeTime + duration, roomIdx});
            }
        }

        int maxMeetings = -1;
        int resultRoom = -1;

        for (int i = 0; i < n; i++) {
            if (meetingCounts[i] > maxMeetings) {
                maxMeetings = meetingCounts[i];
                resultRoom = i;
            }
        }

        return resultRoom;
    }
}