package solutions;

/*
 * @lc app=leetcode id=797 lang=java
 *
 * [797] All Paths From Source to Target
 */
import java.util.*;

// @lc code=start
class Solution {

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);

        backtrack(graph, 0, result, path);
        return result;
    }

    private void backtrack(int[][] graph, int idx, List<List<Integer>> result, List<Integer> tmp) {

        if (idx == graph.length - 1) {
            result.add(new ArrayList<>(tmp));
            return;
        }

        for (int node : graph[idx]) {
            tmp.add(node);
            backtrack(graph, node, result, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }
}
// @lc code=end
