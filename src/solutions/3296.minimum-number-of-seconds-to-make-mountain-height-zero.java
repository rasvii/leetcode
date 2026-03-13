package solutions;
/*
 * @lc app=leetcode id=3296 lang=java
 *
 * [3296] Minimum Number of Seconds to Make Mountain Height Zero
 */

import java.util.PriorityQueue;

// @lc code=start
class Solution {
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {

        PriorityQueue<long[]> q = new PriorityQueue<>((a,b) -> Long.compare(a[0], b[0]));

        for(int time : workerTimes) {
            q.offer(new long[]{time, time, 1});
        }

        long ans = 0;

        for(int i = 0; i < mountainHeight; i++) {
            long[] top = q.poll();
            ans = top[0];

            q.offer(new long[]{top[0] + top[1] * (top[2] + 1), top[1], top[2]+1});
        }

        return ans;
        
    }
}
// @lc code=end

