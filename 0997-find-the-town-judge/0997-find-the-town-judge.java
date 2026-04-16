class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] degree = new int[n + 1];

        // Step 1: Process trust relationships
        for (int[] t : trust) {
            int a = t[0];
            int b = t[1];

            degree[a]--; // a trusts someone
            degree[b]++; // b is trusted
        }

        // Step 2: Find the judge
        for (int i = 1; i <= n; i++) {
            if (degree[i] == n - 1) {
                return i;
            }
        }

        return -1;
    }
}