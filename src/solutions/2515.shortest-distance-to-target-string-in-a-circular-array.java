package solutions;
/*
 * @lc app=leetcode id=2515 lang=java
 *
 * [2515] Shortest Distance to Target String in a Circular Array
 */

// @lc code=start
class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {

        int n = words.length;
        int result = words.length;

        for (int i = 0; i < n; i++) {
            if (words[i].equals(target)) {
                int dist = Math.abs(i - startIndex);
                result = Math.min(result, Math.min(dist, n - dist));
            }
        }

        return result < n ? result : -1;

    }
}
// @lc code=end

