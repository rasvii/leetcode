/*
 * @lc app=leetcode id=1944 lang=java
 *
 * [1944] Number of Visible People in a Queue
 */

// @lc code=start

import java.util.Stack;

class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[heights.length];

        for (int i = heights.length - 1; i >= 0; i--) {
            int visiblePeeps = 0;

            while (!stack.isEmpty() && heights[i] > stack.peek()) {
                visiblePeeps++;
                stack.pop();
            }

            if (!stack.isEmpty())
                visiblePeeps++;
            result[i] = visiblePeeps;
            stack.push(heights[i]);
        }

        return result;
    }
}
// @lc code=end
