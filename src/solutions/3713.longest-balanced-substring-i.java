package solutions;
/*
 * @lc app=leetcode id=3713 lang=java
 *
 * [3713] Longest Balanced Substring I
 */

import java.util.Arrays;

// @lc code=start
class Solution {
    public int longestBalanced(String s) {

        int result = 1;
        int n = s.length();
        int[] count = new int[26];

        for (int i = 0; i < n; i++) {

            Arrays.fill(count, 0);
            int max = 0, unique = 0;

            for (int j = i; j < n; j++) {
                int c = s.charAt(j) - 'a';

                if (++count[c] == 1) {
                    unique++;
                }

                max = Math.max(max, count[c]);

                if (max * unique == j - i + 1) {
                    result = Math.max(result, j - i + 1);
                }

            }
        }

        return result;
    }
}

/* class Solution {
    public int longestBalanced(String s) {

        int result = 1;
        int n = s.length();

        for(int i = 0; i < n; i++) {

            int[] count = new int[26];
            // HashMap<Character, Integer> map = new HashMap<>();
            Set<Character> chars = new HashSet<>();

            for(int j = i; j < n; j++) {
                // map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
                count[s.charAt(j) - 'a']++;
                chars.add(s.charAt(j));

                boolean firstfound = false, isBalanced = true;
                int firstcount = 0;
                for(char c : chars) {
                    
                    if(!firstfound) {
                        firstcount = count[c - 'a'];
                        firstfound = true;
                    }
                    else {
                        if(count[c - 'a'] != firstcount) {
                            isBalanced = false;
                            break;
                        }
                    }
                }

                if(isBalanced) {
                    result = Math.max(result, j-i + 1);
                }

            }
        }

        return result;
        
    }
} */
// @lc code=end

