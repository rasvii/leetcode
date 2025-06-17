package solutions;
/*
 * @lc app=leetcode id=131 lang=java
 *
 * [131] Palindrome Partitioning
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(String s, int start, List<String> tempList, List<List<String>> result) {
        if (start == s.length()) {
            result.add(new ArrayList<>(tempList));
            return;
        } else {
            for (int i = start; i < s.length(); i++) {
                if (isPalindrome(s, start, i)) {
                    tempList.add(s.substring(start, i + 1));
                    backtrack(s, i + 1, tempList, result);
                    tempList.remove(tempList.size() - 1);
                }
            }
        }
    }

    private boolean isPalindrome(String s, int low, int high) {

        while (low < high) {
            if (s.charAt(low++) != s.charAt(high--))
                return false;
        }

        return true;
    }
}
// @lc code=end
