package solutions;

/*
 * @lc app=leetcode id=22 lang=java
 *
 * [22] Generate Parentheses
 */

// @lc code=start

import java.util.*;

class Solution {

    private void backtrack(int n, String curr, int left, int right, List<String> result) {

        if (curr.length() == (n * 2)) {
            result.add(curr);
            return;
        }

        if (left < n) {
            backtrack(n, curr + "(", left + 1, right, result);
        }

        if (right < left) {
            backtrack(n, curr + ")", left, right + 1, result);
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(n, "", 0, 0, result);
        return result;
    }
}
// @lc code=end
