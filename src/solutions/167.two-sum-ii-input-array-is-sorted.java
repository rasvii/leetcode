package solutions;
/*
 * @lc app=leetcode id=167 lang=java
 *
 * [167] Two Sum II - Input Array Is Sorted
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] numbers, int target) {

        int start = 0;
        int end = numbers.length - 1;

        while (start <= end) {

            int sum = numbers[start] + numbers[end];

            if (sum == target) {
                break;
            } else if (sum > target) {
                end--;
            } else {
                start++;
            }

        }

        return new int[] { start + 1, end + 1 };

    }
}
// @lc code=end
