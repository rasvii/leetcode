package solutions;
/*
 * @lc app=leetcode id=1129 lang=java
 *
 * [1129] Shortest Path with Alternating Colors
 */

// @lc code=start

import java.util.*;

class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {

        Map<Integer, List<Integer>> red = new HashMap<>();
        Map<Integer, List<Integer>> blue = new HashMap<>();

        for (int[] edge : redEdges) {

            if (red.get(edge[0]) == null) {
                red.put(edge[0], new ArrayList<>());
            }
            red.get(edge[0]).add(edge[1]);
        }

        for (int[] edge : blueEdges) {

            if (blue.get(edge[0]) == null) {
                blue.put(edge[0], new ArrayList<>());
            }
            blue.get(edge[0]).add(edge[1]);
        }

        // 0th index: node, 1st: length, 2nd: color;
        // colors: 0=none, 1=red, 2=blue;
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] { 0, 0, Color.None.getValue() });

        int[] result = new int[n];
        Arrays.fill(result, -1);

        Set<String> visited = new HashSet<>();

        while (!q.isEmpty()) {
            int[] node = q.poll();

            if (result[node[0]] == -1) {
                result[node[0]] = node[1];
            }

            if (node[2] != Color.Red.getValue()) {
                for (int neigh : red.getOrDefault(node[0], new ArrayList<>())) {
                    if (visited.add(String.valueOf(neigh) + "_1")) {
                        q.offer(new int[] { neigh, node[1] + 1, Color.Red.getValue() });
                    }
                }
            }

            if (node[2] != Color.Blue.getValue()) {
                for (int neigh : blue.getOrDefault(node[0], new ArrayList<>())) {
                    if (visited.add(String.valueOf(neigh) + "_2")) {
                        q.offer(new int[] { neigh, node[1] + 1, Color.Blue.getValue() });
                    }
                }
            }
        }

        return result;

    }
}

enum Color {
    None(0),
    Red(1),
    Blue(2);

    private final int value;

    Color(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
// @lc code=end
