/*
 * @lc app=leetcode id=739 lang=java
 *
 * [739] Daily Temperatures
 */

// @lc code=start

import java.util.Stack;

class Solution {
    // Time complexity : O(n);
    // Space complexity : O(n);
    public int[] dailyTemperatures(int[] temperatures) {
        int result[] = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = temperatures.length - 1; i >= 0; i--) {
            while (!stack.isEmpty()) {
                if (temperatures[i] >= temperatures[stack.peek()]) {
                    stack.pop();
                } else {
                    int idx = stack.peek();
                    result[i] = idx - i;
                    break;
                }
            }

            stack.push(i);
        }

        return result;
    }
}
// @lc code=end
