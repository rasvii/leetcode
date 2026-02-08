package solutions;
/*
 * @lc app=leetcode id=1653 lang=java
 *
 * [1653] Minimum Deletions to Make String Balanced
 */

// @lc code=start
class Solution {
    public int minimumDeletions(String s) {

        int n = s.length();
        int totalA = 0;

        for(char c: s.toCharArray()) {
            if(c == 'a') totalA++;
        }

        int bCount = 0;
        int result = n;

        for(int i = 0; i < n; i++) {
            if(s.charAt(i) == 'a') totalA--;
            result = Math.min(result, totalA + bCount);
            if(s.charAt(i) == 'b') bCount++;
        }

        return result;
        
    }
}
// @lc code=end

