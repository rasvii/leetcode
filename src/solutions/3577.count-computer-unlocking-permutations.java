package solutions;

class Solution {
    static final int MOD = 1_000_000_007;

    public int countPermutations(int[] complexity) {

        int n = complexity.length;

        for (int i = 1; i < n; i++) {
            if (complexity[i] <= complexity[0]) {
                return 0;
            }
        }

        return (int) factorial(n - 1);

    }

    private long factorial(int n) {
        if (n == 0 || n == 1)
            return 1;
        return (n * factorial(n - 1)) % MOD;
    }
}
