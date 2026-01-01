package solutions;

class Solution {
    public int[] plusOne(int[] digits) {

        int i = digits.length;
        boolean isCarry = true;

        while (--i >= 0) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }

            digits[i] = 0;
        }

        int[] result = new int[digits.length + 1];
        result[0] = 1;

        return result;
    }
}

/*
 * class Solution {
 * public int[] plusOne(int[] digits) {
 * 
 * int n = digits.length;
 * boolean isCarry = true;
 * 
 * while (--n >= 0) {
 * if (!isCarry)
 * break;
 * 
 * int num = digits[n] + 1;
 * 
 * if (num > 9) {
 * digits[n] = 0;
 * } else {
 * digits[n] = num;
 * isCarry = false;
 * }
 * }
 * 
 * if (n < 0 && isCarry) {
 * int[] result = new int[digits.length + 1];
 * result[0] = 1;
 * return result;
 * }
 * 
 * return digits;
 * }
 * }
 */