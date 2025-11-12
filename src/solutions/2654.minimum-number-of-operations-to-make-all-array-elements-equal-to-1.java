package solutions;
/*
 * @lc app=leetcode id=2654 lang=java
 *
 * [2654] Minimum Number of Operations to Make All Array Elements Equal to 1
 */

// @lc code=start
class Solution {
    public int minOperations(int[] nums) {

        int n = nums.length;
        int oneCount = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                oneCount++;
            }
        }

        if (oneCount > 0) {
            return n - oneCount;
        }

        int result = Integer.MAX_VALUE;

        for (int i = 0; i < n - 1; i++) {

            int gcd = nums[i];

            for (int j = i + 1; j < n; j++) {
                gcd = findGCD(gcd, nums[j]);

                if (gcd == 1) {
                    result = Math.min(result, j - i + (n - 1));
                    break;
                }
            }
        }

        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private int findGCD(int a, int b) {
        if (a == 0) {
            return b;
        }
        return findGCD(b % a, a);
    }
}
// @lc code=end
