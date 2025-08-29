package solutions;
/*
 * @lc app=leetcode id=347 lang=java
 *
 * [347] Top K Frequent Elements
 */

// @lc code=start

import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int n : nums) {
            freq.put(n, freq.getOrDefault(n, 0) + 1);
        }

        List<Integer>[] bucket = new List[nums.length + 1];
        for (int n : freq.keySet()) {
            int val = freq.get(n);
            if (bucket[val] == null) {
                bucket[val] = new ArrayList<>();
            }
            bucket[val].add(n);
        }

        List<Integer> result = new ArrayList<>();
        for (int i = bucket.length - 1; i >= 0; i--) {
            if (bucket[i] == null)
                continue;
            result.addAll(bucket[i]);
            if (result.size() >= k) {
                break;
            }
        }

        return result.stream().mapToInt(Integer::valueOf).toArray();
    }
}
/*
 * class Solution {
 * public int[] topKFrequent(int[] nums, int k) {
 * 
 * HashMap<Integer, Integer> map = new HashMap<>();
 * 
 * for (int num : nums) {
 * map.put(num, map.getOrDefault(num, 0) + 1);
 * }
 * 
 * PriorityQueue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<>(
 * (a, b) -> Integer.compare(b.getValue(), a.getValue()));
 * 
 * for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
 * heap.add(entry);
 * }
 * 
 * int[] result = new int[k];
 * for (int i = 0; i < k; i++) {
 * result[i] = heap.poll().getKey();
 * }
 * 
 * return result;
 * 
 * }
 * }
 */
// @lc code=end
