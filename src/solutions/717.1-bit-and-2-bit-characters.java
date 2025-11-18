package solutions;
/*
 * @lc app=leetcode id=717 lang=java
 *
 * [717] 1-bit and 2-bit Characters
 */

// @lc code=start
class Solution {
    public boolean isOneBitCharacter(int[] bits) {

        int n = bits.length;
        int i = 0;

        while (i < n - 1) {
            if (bits[i] == 0)
                i++;
            else
                i += 2;
        }

        return i == n - 1;
    }
}
/*
 * class Solution {
 * public boolean isOneBitCharacter(int[] bits) {
 * 
 * int n = bits.length;
 * boolean isTwo = false;
 * 
 * for(int i = 0; i < n; i++) {
 * 
 * if(i == n-1 && isTwo) return false;
 * 
 * if(bits[i] == 1 && !isTwo) {
 * isTwo = true;
 * }
 * else {
 * isTwo = false;
 * }
 * }
 * 
 * return true;
 * 
 * }
 * }
 */
// @lc code=end
