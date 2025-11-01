package solutions;
/*
 * @lc app=leetcode id=1615 lang=java
 *
 * [1615] Maximal Network Rank
 */

// @lc code=start
class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {

        int[] count = new int[n];
        boolean[][] graph = new boolean[n][n];

        for (int[] road : roads) {
            count[road[0]]++;
            count[road[1]]++;
            graph[road[0]][road[1]] = true;
            graph[road[1]][road[0]] = true;
        }

        int result = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int total = count[i] + count[j];
                if (graph[j][i]) {
                    total -= 1;
                }
                result = Math.max(result, total);
            }
        }

        return result;
    }
}
// @lc code=end
