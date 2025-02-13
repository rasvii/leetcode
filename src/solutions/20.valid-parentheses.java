package solutions;
/*
 * @lc app=leetcode id=20 lang=java
 *
 * [20] Valid Parentheses
 */

// @lc code=start

import java.util.*;

class Solution {
    public boolean isValid(String s) {
        HashMap<Character, Character> bracketsMap = new HashMap<>();
        bracketsMap.put(']', '[');
        bracketsMap.put(')', '(');
        bracketsMap.put('}', '{');

        Stack<Character> parentheses = new Stack<>();

        for (char c : s.toCharArray()) {
            if (bracketsMap.containsKey(c) && !parentheses.isEmpty()) {
                if (parentheses.pop() != bracketsMap.get(c)) {
                    return false;
                }
            } else {
                parentheses.add(c);
            }
        }

        return parentheses.isEmpty();

    }
}
// @lc code=end
