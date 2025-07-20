package solutions;
/*
 * @lc app=leetcode id=984 lang=java
 *
 * [984] String Without AAA or BBB
 */

// @lc code=start
class Solution {

    // My solution!!
    public String strWithout3a3b(int a, int b) {
        StringBuilder sb = new StringBuilder();
        while (a + b > 0) {
            int max = 2;
            if (b > a) {
                while (max > 0 && b > 0) {
                    sb.append("b");
                    max--;
                    b--;
                }
                if (a > 0)
                    sb.append("a");
                a--;
            } else if (a > b) {
                while (max > 0 && a > 0) {
                    sb.append("a");
                    max--;
                    a--;
                }
                if (b > 0)
                    sb.append("b");
                b--;
            } else {
                sb.append("a");
                sb.append("b");
                a--;
                b--;
            }
        }

        return sb.toString();
    }

    /*
     * public String strWithout3a3b(int a, int b) {
     * 
     * StringBuilder sb = new StringBuilder();
     * while( a+b > 0 ) {
     * 
     * int len = sb.length();
     * 
     * if (len > 1 && sb.charAt(len - 2) == sb.charAt(len - 1)) {
     * if (sb.charAt(len - 1) == 'a') {
     * sb.append("b");
     * b--;
     * } else {
     * sb.append("a");
     * a--;
     * }
     * } else {
     * if( a > b){
     * sb.append("a");
     * a--;
     * }
     * else{
     * sb.append("b");
     * b--;
     * }
     * }
     * }
     * 
     * return sb.toString();
     * }
     */

}
// @lc code=end
