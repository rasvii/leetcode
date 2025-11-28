package solutions;
/*
 * @lc app=leetcode id=2872 lang=java
 *
 * [2872] Maximum Number of K-Divisible Components
 */

// @lc code=start

import java.util.*;

class Solution {

    int result = 0;

    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<>());

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        dfs(0, -1, graph, k, values);

        return result;
    }

    private long dfs(int node, int parent, List<List<Integer>> graph, int k, int[] values) {

        long sum = values[node];

        for (int edge : graph.get(node)) {
            if (edge == parent)
                continue;
            sum += dfs(edge, node, graph, k, values);
        }

        if (sum % k == 0) {
            result++;
            return 0;
        }

        return sum;
    }
}
// @lc code=end
