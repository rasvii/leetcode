package solutions;
/*
 * @lc app=leetcode id=127 lang=java
 *
 * [127] Word Ladder
 */

// @lc code=start

import java.util.*;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Set<String> words = new HashSet<>(wordList);
        if (!words.contains(endWord))
            return 0;

        int steps = 1;
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        int n = beginWord.length();

        Set<String> visited = new HashSet<>();

        while (!q.isEmpty()) {

            int size = q.size();
            steps++;

            while (size-- > 0) {

                String cur = q.poll();

                for (int i = 0; i < n; i++) {

                    char arr[] = cur.toCharArray();

                    for (int c = 'a'; c <= 'z'; c++) {

                        arr[i] = (char) c;

                        String str = new String(arr);

                        if (str.equals(endWord))
                            return steps;

                        if (words.contains(str) && visited.add(str)) {
                            q.offer(str);
                        }
                    }
                }

            }
        }

        return 0;
    }
}
// @lc code=end
