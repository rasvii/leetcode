package solutions;
/*
 * @lc app=leetcode id=3379 lang=java
 *
 * [3379] Transformed Array
 */

// @lc code=start
class Solution {
    public int[] constructTransformedArray(int[] nums) {

        if(nums.length == 1) return nums;

        int n = nums.length;
        int[] result = new int[n];

        for(int i = 0; i < n; i++) {
            
            if(nums[i] == 0) {
                result[i] = 0;
            }
            else if(nums[i] > 0) {
                
                int num = nums[i];
                int idx = i;

                while(num-- > 0) {
                    if(idx == n - 1) {
                        idx = -1;
                    }
                    
                    idx++;
                }

                result[i] = nums[idx];
            }
            else {
                int num = Math.abs(nums[i]);
                int idx = i;

                while(num-- > 0) {
                    if(idx == 0) {
                        idx = n;
                    }
                    
                    idx--;
                }

                result[i] = nums[idx];
            }
        }

        return result;
    }
}
// @lc code=end

