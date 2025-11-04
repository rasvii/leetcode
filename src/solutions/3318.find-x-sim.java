package solutions;

import java.util.*;

class Solution {
    public int[] findXSum(int[] nums, int k, int x) {

        int n = nums.length;
        int resultSize = n - k + 1;
        int[] result = new int[resultSize];

        Map<Integer, Integer> freq = new HashMap<>();

        for (int i = 0; i <= k - 1; i++) {
            freq.put(nums[i], 1 + freq.getOrDefault(nums[i], 0));
        }

        for (int i = 0; i < resultSize; i++) {
            int sum = xsum(nums, i, i + k - 1, x, freq);
            result[i] = sum;
        }

        return result;
    }

    private int xsum(int[] nums, int start, int end, int x, Map<Integer, Integer> freq) {

        if (start != 0) {
            freq.put(nums[start - 1], freq.get(nums[start - 1]) - 1);
            freq.put(nums[end], freq.getOrDefault(nums[end], 0) + 1);
        }

        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> {
            if (a[1] == b[1]) {
                return b[0] - a[0];
            } else {
                return b[1] - a[1];
            }
        });

        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            if (entry.getValue() == 0)
                continue;
            heap.add(new int[] { entry.getKey(), entry.getValue() });
        }

        int result = 0;

        while (x-- > 0) {
            int[] cur = heap.poll();
            if (cur == null) {
                break;
            }

            result += (cur[0] * cur[1]);
        }

        return result;
    }
}
