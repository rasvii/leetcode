package solutions;
/*
 * @lc app=leetcode id=2943 lang=java
 *
 * [2943] Maximize Area of Square Hole in Grid
 */

// @lc code=start
class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {

        Arrays.sort(hBars);
        Arrays.sort(vBars);

        int hmax = 1, vmax = 1, hcur = 1, vcur = 1;


        for(int i = 1; i < hBars.length; i++) {
            if(hBars[i] == hBars[i - 1] + 1) {
                hcur++;
            }
            else {
                hcur = 1;
            }
            hmax = Math.max(hmax, hcur);
        }
        
        for(int i = 1; i < vBars.length; i++) {
            if(vBars[i] == vBars[i - 1] + 1) {
                vcur++;
            }
            else {
                vcur = 1;
            }
            vmax = Math.max(vmax, vcur);
        }

        int side = Math.min(hmax, vmax) + 1;
        
        return side * side;
    }
}
// @lc code=end

