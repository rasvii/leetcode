package solutions;
/*
 * @lc app=leetcode id=2402 lang=java
 *
 * [2402] Meeting Rooms III
 */

import java.util.*;

// @lc code=start
class Solution {
    public int mostBooked(int n, int[][] meetings) {

        Arrays.sort(meetings, (a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(a[1], b[1]);
            } else {
                return Integer.compare(a[0], b[0]);
            }
        });

        PriorityQueue<Integer> freeRooms = new PriorityQueue<>((a, b) -> Integer.compare(a, b));
        int[] count = new int[n];
        // occupied[0] = room number, occupied[1] = end time
        PriorityQueue<long[]> occupied = new PriorityQueue<>((a, b) -> {
            if (a[1] == b[1]) {
                return Long.compare(a[0], b[0]);
            } else {
                return Long.compare(a[1], b[1]);
            }
        });

        for (int i = 0; i < n; i++) {
            freeRooms.offer(i);
        }

        for (int[] meet : meetings) {
            long start = meet[0];
            long end = meet[1];

            while (!occupied.isEmpty() && occupied.peek()[1] <= start) {
                freeRooms.offer((int) occupied.poll()[0]);
            }

            if (!freeRooms.isEmpty()) {
                int room = freeRooms.poll();
                count[room]++;
                occupied.offer(new long[] { room, end });
            } else {
                long[] peek = occupied.poll();
                int room = (int) peek[0];
                long newEnd = peek[1] + (end - start);
                count[room]++;
                occupied.offer(new long[] { room, newEnd });
            }
        }

        int result = 0, maxCount = 0;

        for (int i = 0; i < n; i++) {
            System.out.println(count[i]);
            if (count[i] > maxCount) {
                maxCount = count[i];
                result = i;
            }
        }

        return result;
    }
}
// @lc code=end
