package solutions;
/*
 * @lc app=leetcode id=268 lang=java
 *
 * [268] Missing Number
 */

// @lc code=start
class Solution {
    public int missingNumber(int[] nums) {
        int rangeTotal = 0;

        for (int i = 0; i <= nums.length; i++) {
            rangeTotal += i;
        }

        int total = 0;
        for (int i : nums) {
            total += i;
        }

        return rangeTotal - total;
    }
}

// class Solution {
//     public int missingNumber(int[] nums) {

//         int[] count = new int[nums.length + 1];

//         Arrays.fill(count, -1);

//         for(int n : nums) {
//             count[n]++;
//         }

//         for(int i = 0; i <= nums.length; i++) {
//             if(count[i] == -1) return i;
//         }
        
//         return -1;
//     }
// }
// @lc code=end
