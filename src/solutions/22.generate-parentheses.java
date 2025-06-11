package solutions;

/*
 * @lc app=leetcode id=22 lang=java
 *
 * [22] Generate Parentheses
 */

// @lc code=start

import java.util.*;

class Solution {
    public List<String> generateParenthesis(int n) {

        List<String> result = new ArrayList<>();
        backtrack(n, "", 0, 0, result);

        return result;
    }

    private void backtrack(int n, String s, int left, int right, List<String> result) {

        if (s.length() == n * 2) {
            result.add(s);
            return;
        }

        if (left < n) {
            backtrack(n, s + "(", left + 1, right, result);
        }

        if (right < left) {
            backtrack(n, s + ")", left, right + 1, result);
        }
    }
}
// @lc code=end
