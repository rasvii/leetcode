package solutions;
/*
 * @lc app=leetcode id=997 lang=java
 *
 * [997] Find the Town Judge
 */

// @lc code=start
class Solution {
    public int findJudge(int n, int[][] trust) {

        int[] trustCount = new int[n + 1];

        for (int[] t : trust) {
            trustCount[t[0]]--;
            trustCount[t[1]]++;
        }

        for (int i = 1; i <= n; i++) {
            if (trustCount[i] == n - 1) {
                return i;
            }
        }

        return -1;

    }
}
// @lc code=end
