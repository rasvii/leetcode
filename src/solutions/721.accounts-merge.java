package solutions;
/*
 * @lc app=leetcode id=721 lang=java
 *
 * [721] Accounts Merge
 */

// @lc code=start

import java.util.*;

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        Map<String, List<Integer>> emailAccounts = new HashMap<>();
        int n = accounts.size();
        boolean[] visited = new boolean[n];
        List<List<String>> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            List<String> account = accounts.get(i);

            for (int j = 1; j < account.size(); j++) {

                if (!emailAccounts.containsKey(account.get(j))) {
                    emailAccounts.put(account.get(j), new ArrayList<>());
                }
                emailAccounts.get(account.get(j)).add(i);
            }
        }

        for (int i = 0; i < n; i++) {
            if (visited[i])
                continue;
            Set<String> emails = new HashSet<>();
            dfs(i, accounts, visited, emailAccounts, emails);

            List<String> merged = new ArrayList<>();
            merged.add(accounts.get(i).get(0)); // name
            List<String> sortedEmails = new ArrayList<>(emails);
            Collections.sort(sortedEmails);
            merged.addAll(sortedEmails);
            result.add(merged);
        }

        return result;

    }

    private void dfs(int idx, List<List<String>> accounts, boolean[] visited, Map<String, List<Integer>> emailAccounts,
            Set<String> emails) {
        if (visited[idx])
            return;

        visited[idx] = true;

        for (int i = 1; i < accounts.get(idx).size(); i++) {
            String email = accounts.get(idx).get(i);
            emails.add(email);
            for (int neighbor : emailAccounts.getOrDefault(email, Collections.emptyList())) {
                dfs(neighbor, accounts, visited, emailAccounts, emails);
            }
        }
    }
}

// Union Find
/*
 * class Solution {
 * public List<List<String>> accountsMerge(List<List<String>> accounts) {
 * Map<String, String> owner = new HashMap<>();
 * Map<String, String> parent = new HashMap<>();
 * 
 * for (List<String> account : accounts) {
 * String name = account.get(0);
 * for (int i = 1; i < account.size(); i++) {
 * String email = account.get(i);
 * parent.putIfAbsent(email, email);
 * owner.put(email, name);
 * }
 * }
 * 
 * // Step 2: Union all emails within each account
 * for(List<String> account : accounts) {
 * String rootEmail = account.get(1);
 * 
 * for(int i = 2; i < account.size(); i++) {
 * union(rootEmail, account.get(i), parent);
 * }
 * }
 * 
 * // Step 3: Group emails by their root parent
 * Map<String, TreeSet<String>> unions = new HashMap<>();
 * for (String email : parent.keySet()) {
 * String root = find(email, parent);
 * unions.computeIfAbsent(root, x -> new TreeSet<>()).add(email);
 * }
 * 
 * // Step 4: Build the result
 * List<List<String>> res = new ArrayList<>();
 * for (String root : unions.keySet()) {
 * List<String> merged = new ArrayList<>();
 * merged.add(owner.get(root));
 * merged.addAll(unions.get(root));
 * res.add(merged);
 * }
 * 
 * return res;
 * }
 * 
 * private String find(String x, Map<String, String> parent) {
 * if (!parent.get(x).equals(x))
 * parent.put(x, find(parent.get(x), parent)); // path compression
 * return parent.get(x);
 * }
 * 
 * private void union(String a, String b, Map<String, String> parent) {
 * String rootA = find(a, parent);
 * String rootB = find(b, parent);
 * if (!rootA.equals(rootB))
 * parent.put(rootA, rootB);
 * }
 * }
 */
// @lc code=end
