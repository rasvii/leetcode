package solutions;
/*
 * @lc app=leetcode id=32 lang=java
 *
 * [32] Longest Valid Parentheses
 */

// @lc code=start

import java.util.Stack;

class Solution {
    public int longestValidParentheses(String s) {
        if (s.length() < 2) {
            return 0;
        }

        Stack<Integer> stack = new Stack<>();
        int[] valid = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                if (!stack.isEmpty()) {
                    int idx = stack.pop();
                    valid[i] = 1;
                    valid[idx] = 1;
                }
            }
        }

        int maxLen = 0, curr = 0;

        for (int i = 0; i < valid.length; i++) {
            curr = (valid[i] == 1) ? (curr + 1) : 0;

            if (curr > maxLen) {
                maxLen = curr;
            }
        }

        return maxLen;
    }
}
// @lc code=end
