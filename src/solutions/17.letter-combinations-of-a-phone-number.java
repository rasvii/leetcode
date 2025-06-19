package solutions;

/*
 * @lc app=leetcode id=17 lang=java
 *
 * [17] Letter Combinations of a Phone Number
 */

// @lc code=start

import java.util.*;

class Solution {

    private static final Map<Character, String> numVsLetterMap = Collections.unmodifiableMap(
            new HashMap<Character, String>() {
                {
                    put('2', "abc");
                    put('3', "def");
                    put('4', "ghi");
                    put('5', "jkl");
                    put('6', "mno");
                    put('7', "pqrs");
                    put('8', "tuv");
                    put('9', "wxyz");
                }
            });

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.length() == 0) {
            return result;
        }
        backtrack(0, "", digits, result);
        return result;
    }

    private void backtrack(int start, String curr, String digits, List<String> result) {
        if (curr.length() == digits.length()) {
            result.add(curr);
            return;
        }
        String letters = numVsLetterMap.get(digits.charAt(start));
        for (char letter : letters.toCharArray()) {
            backtrack(start + 1, curr + letter, digits, result);
        }
    }
}
// @lc code=end
