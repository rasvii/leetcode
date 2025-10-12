package solutions;
/*
 * @lc app=leetcode id=1192 lang=java
 *
 * [1192] Critical Connections in a Network
 */

// @lc code=start

import java.util.*;

class Solution {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<>());

        for (List<Integer> con : connections) {
            graph.get(con.get(0)).add(con.get(1));
            graph.get(con.get(1)).add(con.get(0));
        }

        int timer = 0;
        List<List<Integer>> results = new ArrayList<>();
        boolean[] visited = new boolean[n];
        int[] lowestNode = new int[n];
        dfs(graph, -1, 0, timer, visited, results, lowestNode);
        return results;
    }

    private void dfs(List<List<Integer>> graph, int parent, int cur, int timer, boolean[] visited,
            List<List<Integer>> results, int[] lowestNode) {
        visited[cur] = true;
        lowestNode[cur] = timer++;
        int currentNodeLowest = lowestNode[cur];

        for (int neigh : graph.get(cur)) {
            if (neigh == parent)
                continue;
            if (!visited[neigh])
                dfs(graph, cur, neigh, timer, visited, results, lowestNode);
            lowestNode[cur] = Math.min(lowestNode[neigh], lowestNode[cur]);
            if (currentNodeLowest < lowestNode[neigh])
                results.add(Arrays.asList(cur, neigh));
        }
    }
}
// @lc code=end
