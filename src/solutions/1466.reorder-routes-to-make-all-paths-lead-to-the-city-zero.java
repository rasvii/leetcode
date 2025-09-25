package solutions;
/*
 * @lc app=leetcode id=1466 lang=java
 *
 * [1466] Reorder Routes to Make All Paths Lead to the City Zero
 */

// @lc code=start

import java.util.*;

class Solution {

    // https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/?envType=study-plan-v2&envId=graph-theory

    private int ans = 0;

    public int minReorder(int n, int[][] connections) {
        Map<Integer, List<Integer>> in = new HashMap<>();
        Map<Integer, List<Integer>> out = new HashMap<>();

        // for(int i = 0; i < n; i++) {
        // in.put(i, new ArrayList<>());
        // out.put(i, new ArrayList<>());
        // }

        for (int[] conn : connections) {
            if (out.get(conn[0]) == null) {
                out.put(conn[0], new ArrayList<>());
            }

            if (in.get(conn[1]) == null) {
                in.put(conn[1], new ArrayList<>());
            }
            out.get(conn[0]).add(conn[1]);
            in.get(conn[1]).add(conn[0]);
        }

        boolean[] visited = new boolean[n];

        dfs(0, in, out, visited);

        return ans;
    }

    private void dfs(int idx, Map<Integer, List<Integer>> in, Map<Integer, List<Integer>> out, boolean[] visited) {

        visited[idx] = true;

        if (out.containsKey(idx)) {
            for (int o : out.get(idx)) {
                if (visited[o])
                    continue;

                ans++;
                dfs(o, in, out, visited);
            }
        }

        if (in.containsKey(idx)) {
            for (int i : in.get(idx)) {

                if (visited[i])
                    continue;

                dfs(i, in, out, visited);
            }
        }
    }
}
// @lc code=end
