package solutions;

class Solution {
    public long maxSubarraySum(int[] nums, int k) {

        int n = nums.length;
        long[] prefix = new long[n + 1];

        for (int i = 1; i <= n; i++) {
            prefix[i] = nums[i - 1] + prefix[i - 1];
        }

        long[] dp = new long[n + 1];
        long max = prefix[k];

        // bacially mean that you either start a fresh subarray from
        // the current chunk or you extend the previous one.
        for (int i = k; i <= n; i++) {
            long chunk = prefix[i] - prefix[i - k];
            dp[i] = Math.max(chunk, dp[i - k] + chunk);
            max = Math.max(dp[i], max);
        }

        return max;

    }
}
