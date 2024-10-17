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

    public void backtrack(List<String> result, int index, String curr, String digits) {

        if (index == digits.length()) {
            result.add(curr);
            return;
        }

        String letters = numVsLetterMap.get(digits.charAt(index));
        for (char letter : letters.toCharArray()) {
            backtrack(result, index + 1, curr + letter, digits);
        }

    }

    public List<String> letterCombinations(String digits) {

        List<String> result = new ArrayList<>();
        int length = digits.length();

        if (length == 0) {
            return result;
        }

        if (length == 1) {
            String val = numVsLetterMap.get(digits.charAt(0));
            return Arrays.asList(val.split(""));
        }

        backtrack(result, 0, "", digits);

        return result;

    }
}
// @lc code=end
