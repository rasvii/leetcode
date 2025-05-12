package solutions;
/*
 * @lc app=leetcode id=75 lang=java
 *
 * [75] Sort Colors
 */

// @lc code=start
class Solution {
    public void sortColors(int[] nums) {

        int red = 0, white = 0, blue = 0;

        for (int n : nums) {
            if (n == 0)
                red++;
            else if (n == 1)
                white++;
            else
                blue++;
        }

        for (int i = 0; i < red; i++)
            nums[i] = 0;
        for (int i = red; i < red + white; i++)
            nums[i] = 1;
        for (int i = white + red; i < red + white + blue; i++)
            nums[i] = 2;

    }
}
// @lc code=end
