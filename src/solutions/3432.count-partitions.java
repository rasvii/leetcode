package solutions;

class Solution {
    public int countPartitions(int[] nums) {

        int total = 0;

        for (int n : nums)
            total += n;

        int count = 0;
        int leftSum = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            leftSum += nums[i];

            if ((leftSum - (total - leftSum)) % 2 == 0) {
                count++;
            }
        }

        return count;
    }
}

/*
 * class Solution {
 * public int countPartitions(int[] nums) {
 * 
 * int n = nums.length;
 * int[] prefix = new int[n];
 * prefix[0] = nums[0];
 * 
 * for (int i = 1; i < n; i++) {
 * prefix[i] = nums[i] + prefix[i - 1];
 * }
 * 
 * int count = 0;
 * 
 * for (int i = 0; i < n - 1; i++) {
 * if ((prefix[i] - prefix[n - 1] - prefix[i]) % 2 == 0)
 * count++;
 * }
 * 
 * return count;
 * }
 * }
 */