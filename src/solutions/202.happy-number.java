package solutions;
/*
 * @lc app=leetcode id=202 lang=java
 *
 * [202] Happy Number
 */

// @lc code=start
import java.util.*;

class Solution {
    public boolean isHappy(int n) {

        HashSet<Integer> visitedNumbers = new HashSet<>();

        while (!visitedNumbers.contains(n)) {
            visitedNumbers.add(n);
            n = getNextNumber(n);
            if (n == 1) {
                return true;
            }
        }

        return false;
    }

    private int getNextNumber(int n) {
        int sum = 0;
        int remainder = 0;

        while (n > 0) {
            remainder = n % 10;
            sum += remainder * remainder;
            n = n / 10;
        }

        return sum;
    }
}
// @lc code=end
