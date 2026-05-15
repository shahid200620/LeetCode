import java.util.ArrayList;
import java.util.List;

class Solution {
    List<Integer>[] adj;
    int[] nums;
    int[] xorSum;
    int[] parent;
    int[] depth;
    int totalXOR;
    int minScore;

    public int minimumScore(int[] nums, int[][] edges) {
        int n = nums.length;
        this.nums = nums;
        adj = new ArrayList[n];
        xorSum = new int[n];
        parent = new int[n];
        depth = new int[n];
        minScore = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
            totalXOR ^= nums[i];
        }

        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }

        dfs(0, -1, 0);

        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int xor1, xor2, xor3;

                // Case 1: j is a descendant of i
                if (isDescendant(j, i)) {
                    xor1 = xorSum[j];
                    xor2 = xorSum[i] ^ xorSum[j];
                    xor3 = totalXOR ^ xorSum[i];
                }
                // Case 2: i is a descendant of j
                else if (isDescendant(i, j)) {
                    xor1 = xorSum[i];
                    xor2 = xorSum[j] ^ xorSum[i];
                    xor3 = totalXOR ^ xorSum[j];
                }
                // Case 3: i and j are in different subtrees (neither is ancestor of other)
                else {
                    xor1 = xorSum[i];
                    xor2 = xorSum[j];
                    xor3 = totalXOR ^ xorSum[i] ^ xorSum[j];
                }

                int maxVal = Math.max(xor1, Math.max(xor2, xor3));
                int minVal = Math.min(xor1, Math.min(xor2, xor3));
                minScore = Math.min(minScore, maxVal - minVal);
            }
        }

        return minScore;
    }

    private void dfs(int u, int p, int d) {
        parent[u] = p;
        depth[u] = d;
        xorSum[u] = nums[u];

        for (int v : adj[u]) {
            if (v == p) continue;
            dfs(v, u, d + 1);
            xorSum[u] ^= xorSum[v];
        }
    }

    private boolean isDescendant(int descendant, int ancestor) {
        if (depth[descendant] <= depth[ancestor]) {
            return false;
        }
        int curr = descendant;
        while (depth[curr] > depth[ancestor]) {
            if (curr == ancestor) return true; // Should not happen with current logic, but for safety
            curr = parent[curr];
        }
        return curr == ancestor;
    }
}