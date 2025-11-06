package solutions;

import java.util.*;

class Solution {
    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i <= c; i++)
            graph.add(new ArrayList<>());

        for (int[] con : connections) {
            graph.get(con[0]).add(con[1]);
            graph.get(con[1]).add(con[0]);
        }

        int[] component = new int[c + 1];
        int id = 0;
        boolean[] visited = new boolean[c + 1];

        for (int i = 1; i <= c; i++) {
            if (!visited[i]) {
                dfs(i, graph, id, visited, component);
                id++;
            }
        }

        Map<Integer, TreeSet<Integer>> componentGraph = new HashMap<>();
        for (int i = 1; i < component.length; i++) {
            if (!componentGraph.containsKey(component[i])) {
                componentGraph.put(component[i], new TreeSet<>());
            }
            componentGraph.get(component[i]).add(i);
        }

        boolean[] offline = new boolean[c + 1];
        List<Integer> result = new ArrayList<>();

        for (int[] query : queries) {
            int curStation = query[1];
            int belongsTo = component[curStation];
            if (query[0] == 2) {
                offline[curStation] = true;
                componentGraph.get(belongsTo).remove(curStation);
            } else {
                if (!offline[curStation]) {
                    result.add(curStation);
                } else {
                    if (componentGraph.get(belongsTo).isEmpty()) {
                        result.add(-1);
                    } else {
                        result.add(componentGraph.get(belongsTo).first());
                    }
                }
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    private void dfs(int idx, List<List<Integer>> graph, int id, boolean[] visited, int[] comp) {
        visited[idx] = true;
        comp[idx] = id;

        for (int neigh : graph.get(idx)) {
            if (visited[neigh])
                continue;
            dfs(neigh, graph, id, visited, comp);
        }
    }
}
