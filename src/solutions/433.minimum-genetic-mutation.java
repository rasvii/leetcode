package solutions;
/*
 * @lc app=leetcode id=433 lang=java
 *
 * [433] Minimum Genetic Mutation
 */

// @lc code=start

import java.util.*;

class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {

        Set<String> words = new HashSet<>(Arrays.asList(bank));
        if (!words.contains(endGene))
            return -1;

        Set<String> visited = new HashSet<>();
        int steps = 0;
        Set<String> q = new HashSet<>();
        q.add(startGene);

        int n = startGene.length();

        while (!q.isEmpty()) {
            steps++;

            Set<String> next = new HashSet<>();

            for (String word : q) {

                char[] arr = word.toCharArray();

                for (int i = 0; i < n; i++) {

                    char old = arr[i];

                    for (int c = 'A'; c <= 'Z'; c++) {

                        arr[i] = (char) c;

                        String nextWord = new String(arr);

                        if (nextWord.equals(endGene))
                            return steps;

                        if (words.contains(nextWord) && visited.add(nextWord)) {
                            next.add(nextWord);
                        }
                    }

                    arr[i] = old;

                }
            }

            q = next;
        }

        return -1;

    }
}
// @lc code=end
