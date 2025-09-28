package solutions;
/*
 * @lc app=leetcode id=802 lang=java
 *
 * [802] Find Eventual Safe States
 */

import java.util.*;

// @lc code=start
class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;

        List<Integer> result = new ArrayList<>();

        // 0 = unsure, 1 = visiting, 2 = safe;
        int[] state = new int[n];

        for(int i= 0; i < n; i++) {
            if(graph[i].length == 0) {
                state[i] = 2;
            }
        }

        for(int i = 0; i < n; i++) {
            dfs(i, state, graph);
        }

        for(int i = 0; i < n; i++) {
            if(state[i] == 2) {
                result.add(i);
            }
        }

        return result;
    }

    private boolean dfs(int idx, int[] state, int[][] graph) {
        if(state[idx] == 1) return false;
        if(state[idx] == 2) return true;

        state[idx] = 1;

        for(int edge : graph[idx]) {
            if(!dfs(edge, state, graph)) {
                return false;
            }
        }

        state[idx] = 2;

        return true;
    }
}
// @lc code=end

