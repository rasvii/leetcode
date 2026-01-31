package solutions;
/*
 * @lc app=leetcode id=2976 lang=java
 *
 * [2976] Minimum Cost to Convert String I
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {

        // Map<Character, List<Character>> map = new HashMap<>();
        long[][] graph = new long[26][26];

        for(long[] row : graph) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        for(int i = 0; i < original.length; i++) {
            int o = original[i] - 'a';
            int c = changed[i] - 'a';
            // map.computerIfAbsent(o, k -> new ArrayList<>()).add(c);

            graph[o][c] = Math.min((long) cost[i], graph[o][c]);
        }

        for (int k = 0; k < 26; ++k) {
            for (int i = 0; i < 26; ++i) {
                for (int j = 0; j < 26; ++j) {
                    graph[i][j] = Math.min(
                        graph[i][j],
                        graph[i][k] + graph[k][j]
                    );
                }
            }
        }

        long totalCost = 0;

        for (int i = 0; i < source.length(); ++i) {
            if (source.charAt(i) == target.charAt(i)) {
                continue;
            }
            int sourceChar = source.charAt(i) - 'a';
            int targetChar = target.charAt(i) - 'a';

            // If the transformation is not possible, return -1
            if (graph[sourceChar][targetChar] >= Integer.MAX_VALUE) {
                return -1;
            }
            totalCost += graph[sourceChar][targetChar];
        }
        return totalCost;
        
    }
}
// @lc code=end

