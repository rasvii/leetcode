package solutions;

class Solution {
    public long maxProfit(int[] prices, int[] strategy, int k) {
        int n = prices.length;

        long[] prefixsum = new long[n + 1];
        long[] pricesum = new long[n + 1];

        for (int i = 1; i <= n; i++) {
            prefixsum[i] = prefixsum[i - 1] + (strategy[i - 1] * prices[i - 1]);
            pricesum[i] = pricesum[i - 1] + prices[i - 1];
        }

        long result = prefixsum[n];

        for (int i = k - 1; i < n; i++) {
            long leftProfit = prefixsum[i - k + 1];
            long rightProfit = prefixsum[n] - prefixsum[i + 1];
            long change = pricesum[i + 1] - pricesum[i - k / 2 + 1];

            result = Math.max(result, change + leftProfit + rightProfit);
        }

        return result;
    }
}