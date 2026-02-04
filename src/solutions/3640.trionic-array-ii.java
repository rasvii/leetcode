package solutions;
/*
 * @lc app=leetcode id=3640 lang=java
 *
 * [3640] Trionic Array II
 */

// @lc code=start
class Solution {
    public long maxSumTrionic(int[] nums) {

        long result = Long.MIN_VALUE;
        int n = nums.length;

        int i = 1;

        while(i < n) {
            if(i+1 < n && nums[i] > nums[i+1]) {

                int start = i;
                long sum = nums[start];
                
                while(start+1 < n && nums[start] > nums[start+1]) {
                    sum += nums[start+1];
                    start++;
                }

                System.out.println("sum=" + sum);
                int rstart = start+1;
                int lstart = i-1;

                if(rstart >= n || nums[rstart] == nums[start]) {
                    i = rstart;
                    continue;
                }

                long left = nums[lstart], right  = nums[rstart];
                long maxleft = left, maxright = right;

                while(rstart+1 < n && nums[rstart+1] > nums[rstart]) {
                    right += nums[rstart+1];
                    maxright = Math.max(maxright, right);
                    rstart++;
                }

                while(lstart > 0 && nums[lstart-1] < nums[lstart]) {
                    left += nums[lstart-1];
                    lstart--;
                    maxleft = Math.max(maxleft, left);
                }

                i = rstart;

                result = Math.max(result, sum + maxright + maxleft);

            }
            else {
                i++;
            }
        }

        return result;
        
    }
}
// @lc code=end

