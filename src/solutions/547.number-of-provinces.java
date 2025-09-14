package solutions;
/*
 * @lc app=leetcode id=547 lang=java
 *
 * [547] Number of Provinces
 */

// @lc code=start
class Solution {
    public int findCircleNum(int[][] isConnected) {
        int result = 0;

        int[] visited = new int[isConnected.length];

        for (int i = 0; i < isConnected.length; i++) {
            if (visited[i] == 0) {
                helper(isConnected, visited, i);
                result++;
            }
        }

        return result;
    }

    private void helper(int[][] connections, int[] visited, int i) {

        for (int j = 0; j < connections.length; j++) {
            if (visited[j] == 0 && connections[i][j] == 1) {
                visited[j] = 1;
                helper(connections, visited, j);
            }
        }

    }
}
// @lc code=end
