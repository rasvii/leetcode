package solutions;
/*
 * @lc app=leetcode id=120 lang=java
 *
 * [120] Triangle
 */

// @lc code=start

import java.util.List;

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {

        if (triangle == null || triangle.size() == 0)
            return 0;

        int m = triangle.size(), n = triangle.getLast().size();
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            dp[i] = triangle.get(m - 1).get(i);
        }

        for (int i = n - 2; i >= 0; i--) {
            List<Integer> cur = triangle.get(i);

            for (int j = 0; j < cur.size(); j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + cur.get(j);
            }
        }

        return dp[0];

    }
}

/*
 * class Solution {
 * public int minimumTotal(List<List<Integer>> triangle) {
 * 
 * int m = triangle.size(), n = triangle.getLast().size();
 * 
 * for (int i = 1; i < m; i++) {
 * 
 * for (int j = 0; j < i + 1; j++) {
 * 
 * int cur = triangle.get(i).get(j);
 * 
 * if (j == 0) {
 * triangle.get(i).set(j, triangle.get(i - 1).get(0) + cur);
 * } else if (j == i) {
 * triangle.get(i).set(j, triangle.get(i - 1).get(i - 1) + cur);
 * } else {
 * int minParent = Math.min(triangle.get(i - 1).get(j - 1), triangle.get(i -
 * 1).get(j));
 * triangle.get(i).set(j, minParent + cur);
 * }
 * }
 * }
 * 
 * int result = Integer.MAX_VALUE;
 * for (int i = 0; i < n; i++) {
 * result = Math.min(triangle.get(m - 1).get(i), result);
 * }
 * 
 * return result;
 * 
 * }
 * }
 */
// @lc code=end
