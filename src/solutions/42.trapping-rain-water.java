package solutions;
/*
 * @lc app=leetcode id=42 lang=java
 *
 * [42] Trapping Rain Water
 */

// @lc code=start
class Solution {
    public int trap(int[] height) {

        int n = height.length;

        if (n <= 2)
            return 0;

        int left = 0, right = n - 1;
        int maxRight = 0, maxLeft = 0;

        int totalWater = 0;

        while (left < right) {

            if (height[left] < height[right]) {
                if (height[left] >= maxLeft) {
                    maxLeft = height[left];
                } else {
                    totalWater += maxLeft - height[left];
                }

                left++;
            } else {
                if (height[right] >= maxRight) {
                    maxRight = height[right];
                } else {
                    totalWater += maxRight - height[right];
                }

                right--;

            }
        }

        return totalWater;

    }

    // Monotonic stack
    /*
     * public int trap(int[] height) {
     * 
     * int n = height.length;
     * 
     * if(n <= 2){
     * return 0;
     * }
     * 
     * Stack<Integer> stack = new Stack<>();
     * int totalWater = 0;
     * 
     * for(int i = 0; i < height.length; i++){
     * 
     * while(!stack.isEmpty() && height[stack.peek()] < height[i]){
     * int top = height[stack.pop()];
     * if(stack.isEmpty()) break;
     * int width = i - stack.peek() - 1;
     * int high = Math.min(height[stack.peek()], height[i]) - top;
     * totalWater += width * high;
     * }
     * 
     * stack.push(i);
     * }
     * 
     * return totalWater;
     * }
     */
}
// @lc code=end
