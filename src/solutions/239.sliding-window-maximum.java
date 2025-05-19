package solutions;
/*
 * @lc app=leetcode id=239 lang=java
 *
 * [239] Sliding Window Maximum
 */

// @lc code=start

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        int[] result = new int[len - k + 1];
        int idx = 0;

        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < len; i++) {

            // Remove out of range elements
            while (!deque.isEmpty() && deque.peek() < (i - k + 1)) {
                deque.poll();
            }

            // Remove elements smaller than the current one.
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            deque.offer(i);

            if (i >= k - 1) {
                result[idx++] = nums[deque.peek()];
            }
        }

        return result;
    }
}
// @lc code=end
