package solutions;
/*
 * @lc app=leetcode id=326 lang=java
 *
 * [326] Power of Three
 */

// @lc code=start
class Solution {
    public boolean isPowerOfThree(int n) {
        if (n <= 0)
            return false;

        while (n % 3 == 0) {
            n = n / 3;
        }

        return n == 1;
    }

    /*
     * public boolean isPowerOfThree(int n) {
     * return n > 0 && Math.pow(3,19) % n==0;
     * }
     */

    /*
     * public boolean isPowerOfThree(int n) {
     * 
     * if(n <= 0)
     * return false;
     * 
     * return recursion(n);
     * }
     * 
     * private boolean recursion(int n){
     * if(n%3 != 0){
     * return n==1;
     * }
     * return recursion(n/3);
     * }
     */

    /*
     * public boolean isPowerOfThree(int n) {
     * 
     * return n > 0 && (n == 1 || (n%3 == 0 && isPowerOfThree(n/3)));
     * }
     */
}
// @lc code=end
