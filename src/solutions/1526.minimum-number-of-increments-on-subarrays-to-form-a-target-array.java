package solutions;
/*
 * @lc app=leetcode id=1526 lang=java
 *
 * [1526] Minimum Number of Increments on Subarrays to Form a Target Array
 */

// @lc code=start
class Solution {
    public int minNumberOperations(int[] target) {

        int totalOps = target[0];
        int prevNum = target[0];

        for (int i = 1; i < target.length; i++) {
            if (prevNum < target[i]) {
                int diff = target[i] - prevNum;
                prevNum = target[i];
                totalOps += diff;
            } else {
                prevNum = target[i];
            }
        }

        return totalOps;
    }
}
// @lc code=end
