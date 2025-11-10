package solutions;

import java.util.Stack;

class Solution {
    public int minOperations(int[] nums) {

        Stack<Integer> stack = new Stack<>();
        int operations = 0;

        for (int n : nums) {

            while (!stack.isEmpty() && n < stack.peek()) {
                stack.pop();
            }

            if (n == 0)
                continue;

            if (stack.isEmpty() || n > stack.peek()) {
                operations++;
                stack.push(n);
            }
        }

        return operations;
    }

}

// First solution that I did by myself, which was wayyy too lengthy, but, hey,
// at least I tried.

/*
 * class Solution {
 * public int minOperations(int[] nums) {
 * 
 * Stack<Integer> stack = new Stack<>();
 * int operations = 0;
 * 
 * for (int n : nums) {
 * if (n == 0 && !stack.isEmpty()) {
 * while (!stack.isEmpty()) {
 * stack.pop();
 * operations++;
 * }
 * continue;
 * } else if (stack.isEmpty() && n == 0)
 * continue;
 * 
 * if (stack.isEmpty()) {
 * stack.push(n);
 * continue;
 * }
 * 
 * if (stack.peek() > n) {
 * 
 * while (!stack.isEmpty() && stack.peek() > n) {
 * stack.pop();
 * operations++;
 * }
 * 
 * if (stack.isEmpty() || stack.peek() != n) {
 * stack.push(n);
 * }
 * } else if (stack.peek() < n) {
 * stack.push(n);
 * }
 * }
 * 
 * if (!stack.isEmpty())
 * operations += stack.size();
 * 
 * return operations;
 * }
 * 
 * }
 */