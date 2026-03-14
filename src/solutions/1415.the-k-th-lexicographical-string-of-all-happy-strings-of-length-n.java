package solutions;
/*
 * @lc app=leetcode id=1415 lang=java
 *
 * [1415] The k-th Lexicographical String of All Happy Strings of Length n
 */

import java.util.*;

// @lc code=start
class Solution {
    public String getHappyString(int n, int k) {
        char[] chars = {'a', 'b', 'c'};
        List<String> happyStrings = new ArrayList<>();
        backtrack(chars, '0', n, happyStrings, new StringBuilder());
        
        return happyStrings.size() < k ? "" : happyStrings.get(k-1);

    }

    private void backtrack(char[] chars, char prev ,int n, List<String> happyStrings, StringBuilder sb){

        if(sb.length() == n) {
            happyStrings.add(sb.toString());
            return;
        }

        for(char c = 'a'; c <= 'c'; c++){
            if(sb.length() > 0 && sb.charAt(sb.length() - 1) == c) continue;
            sb.append(c);
            backtrack(chars, c, n, happyStrings, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
// @lc code=end

