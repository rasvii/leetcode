package solutions;
/*
 * @lc app=leetcode id=1578 lang=java
 *
 * [1578] Minimum Time to Make Rope Colorful
 */

// @lc code=start
class Solution {
    public int minCost(String s, int[] neededTime) {

        int n = s.length();

        int i = 1;
        int result = 0;

        while (i < n) {
            if (s.charAt(i - 1) == s.charAt(i)) {
                int sum = neededTime[i - 1], max = neededTime[i-1];
                
                while (i < n && s.charAt(i - 1) == s.charAt(i)) {
                    sum += neededTime[i];
                    max = Math.max(max, neededTime[i]);
                    i++;
                }

                sum -= max;
                result += sum;
            }
            else {
                i++;
            }
        }

        return result;

    }
}
// @lc code=end

