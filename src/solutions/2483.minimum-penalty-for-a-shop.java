package solutions;
/*
 * @lc app=leetcode id=2483 lang=java
 *
 * [2483] Minimum Penalty for a Shop
 */

// @lc code=start
class Solution {
    public int bestClosingTime(String customers) {

        int totalY = 0, totalN = 0;

        for (char c : customers.toCharArray()) {
            if (c == 'Y')
                totalY++;
        }

        int n = customers.length();
        int result = n + 1, minPenalty = n;

        for (int i = 0; i <= n; i++) {

            int penalty = totalY + totalN;

            if (totalY + totalN < minPenalty) {
                minPenalty = penalty;
                result = i;
            }

            if (i == n) {
                break;
            }

            if (customers.charAt(i) == 'Y') {
                totalY--;
            } else {
                totalN++;
            }

        }

        return result;
    }
}
// @lc code=end
