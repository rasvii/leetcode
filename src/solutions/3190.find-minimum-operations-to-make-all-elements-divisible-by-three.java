package solutions;
/*
 * @lc app=leetcode id=3190 lang=java
 *
 * [3190] Find Minimum Operations to Make All Elements Divisible by Three
 */

// @lc code=start
class Solution {
    public int minimumOperations(int[] nums) {

        int result = 0;

        for (int n : nums) {
            if (n % 3 == 0)
                continue;
            result++;
        }

        return result;
    }
}
// @lc code=end
