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

        if (nums.length == 1) {
            return nums[0];
        }

        int maxProduct = Integer.MIN_VALUE;
        int prod = 1;

        for (int num : nums) {
            prod = prod * num;
            maxProduct = Math.max(prod, maxProduct);

            if (prod == 0) {
                prod = 1;
            }
        }

        prod = 1;

        for (int i = nums.length - 1; i >= 0; i--) {
            prod = prod * nums[i];
            maxProduct = Math.max(prod, maxProduct);

            if (prod == 0) {
                prod = 1;
            }
        }

        return maxProduct;
    }
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
