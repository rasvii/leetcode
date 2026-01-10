package solutions;

/*
 * @lc app=leetcode id=1390 lang=java
 *
 * [1390] Four Divisors
 */

// @lc code=start
class Solution {
    public int sumFourDivisors(int[] nums) {
        
        int result = 0;

        for(int n : nums) {
            result += divisorSum(n);
        }

        return result;
    }

    private int divisorSum(int n) {
        int sum = n + 1;
        int count = 2;
        int i = 1;
        int sqrt = (int) Math.sqrt(n);

        while(++i <= sqrt) {
            if(count > 4) break;

            if(n % i == 0) {
                sum += i;
                count++;
                if(n/i > sqrt) {
                    sum += (n/i);
                    count++;
                }
            }
        }

        if(count != 4) return 0;

        return sum;
    }
}
// @lc code=end

