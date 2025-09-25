package solutions;
/*
 * @lc app=leetcode id=1376 lang=java
 *
 * [1376] Time Needed to Inform All Employees
 */

// @lc code=start

import java.util.*;

class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < manager.length; i++) {
            if (manager[i] != -1) {
                graph.get(manager[i]).add(i);
            }
        }

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] { headID, informTime[headID] });
        int result = 0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            if (graph.get(cur[0]).isEmpty())
                continue;

            for (int emp : graph.get(cur[0])) {
                q.add(new int[] { emp, cur[1] + informTime[emp] });
                result = Math.max(result, cur[1] + informTime[emp]);
            }

        }

        return result;
    }
}
// @lc code=end
