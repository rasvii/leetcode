package solutions;
/*
 * @lc app=leetcode id=494 lang=java
 *
 * [494] Target Sum
 */

import java.util.Arrays;

// @lc code=start
class Solution {

    int totalSum = 0;

    public int findTargetSumWays(int[] nums, int target) {

        totalSum = Arrays.stream(nums).sum();

        int[][] memo = new int[nums.length][2 * totalSum + 1];
        
        for (int[] row : memo) {
            Arrays.fill(row, Integer.MIN_VALUE);
        }

        return calculate(nums, target, 0, 0, memo);
    }

    private int calculate(int[] nums, int target, int idx, int sum, int[][] memo) {

        if(idx == nums.length) {
            return sum == target ? 1 : 0;
        }
        else {
            if(memo[idx][sum + totalSum] != Integer.MIN_VALUE) {
                return memo[idx][sum + totalSum];  
            }

            int add = calculate(nums, target, idx+1, sum + nums[idx], memo);

            int subtract = calculate(nums, target, idx+1, sum - nums[idx], memo);

            memo[idx][sum + totalSum] = add + subtract;

            return memo[idx][sum + totalSum];
        }
    }
}


// class Solution {

//     int result = 0;

//     public int findTargetSumWays(int[] nums, int target) {
//         calculate(nums, target, 0, 0);
//         return result;
//     }

//     private void calculate(int[] nums, int target, int idx, int sum) {

//         if(idx == nums.length) {
//             if(sum == target) {
//                 result++;
//             }
//         }
//         else {
//             calculate(nums, target, idx+1, sum + nums[idx]);

//             calculate(nums, target, idx+1, sum - nums[idx]);
//         }
//     }
// }
// @lc code=end

