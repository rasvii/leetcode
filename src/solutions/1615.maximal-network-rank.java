package solutions;
/*
 * @lc app=leetcode id=1615 lang=java
 *
 * [1615] Maximal Network Rank
 */

import java.util.*;

// @lc code=start
class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {

        int[] indegree = new int[n];
        List<Set<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new HashSet<>());
        }

        for (int[] road : roads) {
            indegree[road[0]]++;
            indegree[road[1]]++;
            graph.get(road[0]).add(road[1]);
            graph.get(road[1]).add(road[0]);
        }

        int result = 0;
        int curMax = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                curMax = indegree[i] + indegree[j];
                if (graph.get(i).contains(j)) {
                    curMax -= 1;
                }
                result = Math.max(curMax, result);
            }
        }

        return result;
    }
}
// @lc code=end
