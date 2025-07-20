package solutions;
/*
 * @lc app=leetcode id=166 lang=java
 *
 * [166] Fraction to Recurring Decimal
 */

import java.util.HashMap;

// @lc code=start
class Solution {
    public String fractionToDecimal(int numerator, int denominator) {

        boolean isNegative = (numerator > 0 && denominator < 0 || numerator < 0 && denominator > 0) ? true : false;

        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);

        StringBuilder sb = new StringBuilder();
        sb.append(isNegative ? "-" : "");
        sb.append(num / den);
        num %= den;

        if (num == 0) {
            return sb.toString();
        }

        sb.append(".");

        HashMap<Long, Integer> map = new HashMap<>();
        while (num != 0) {
            num *= 10;
            sb.append(num / den);
            num %= den;

            if (map.containsKey(num)) {
                int index = map.get(num);
                sb.insert(index, "(");
                sb.append(")");
                break;
            } else {
                map.put(num, sb.length());
            }
        }

        return sb.toString();
    }
}
// @lc code=end
