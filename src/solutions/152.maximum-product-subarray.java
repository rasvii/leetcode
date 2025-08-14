package solutions;
/*
 * @lc app=leetcode id=152 lang=java
 *
 * [152] Maximum Product Subarray
 */

// @lc code=start
class Solution {
    /*
     * Solution depends on the number of negative numbers. If the count of negative
     * numbers is even then the result obviously works. If odd, then the answer is a
     * subarray. If there is a zero, then the ans is on either side of the number.
     * First we go from left to right, and then right to left as both has different
     * results.
     */
    public int maxProduct(int[] nums) {

        int maxProduct = nums[0], max = nums[0], min = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int tmp = max;

            max = Math.max(Math.max(max * nums[i], min * nums[i]), nums[i]);
            min = Math.min(Math.min(tmp * nums[i], min * nums[i]), nums[i]);

            if (max > maxProduct) {
                maxProduct = max;
            }
        }

        return maxProduct;
    }

    /*
     * public int maxProduct(int[] nums) {
     * 
     * int maxProduct = nums[0], leftSum = 0, rightSum = 0;
     * 
     * for(int i = 0; i < nums.length; i++) {
     * 
     * leftSum = (leftSum == 0 ? 1 : leftSum) * nums[i];
     * rightSum = (rightSum == 0 ? 1 : rightSum) * nums[nums.length - 1 - i];
     * 
     * maxProduct = Math.max(maxProduct, Math.max(leftSum, rightSum));
     * }
     * 
     * return maxProduct;
     * }
     */
}

// Brute force

/*
 * class Solution {
 * public int maxProduct(int[] nums) {
 * 
 * if(nums.length == 1){
 * return nums[0];
 * }
 * 
 * int maxProduct = -1;
 * 
 * for(int i = 0; i < nums.length; i++){
 * 
 * int prod = nums[i];
 * maxProduct = Math.max(maxProduct, prod);
 * 
 * if(prod == 0){
 * continue;
 * }
 * 
 * for(int j = i+1; j < nums.length; j++){
 * prod = prod * nums[j];
 * 
 * maxProduct = Math.max(maxProduct, prod);
 * 
 * if(prod == 0){
 * break;
 * }
 * }
 * }
 * 
 * return maxProduct;
 * }
 * }
 */
// @lc code=end
