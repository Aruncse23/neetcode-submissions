//import java.util.*;

public class Solution {
    public boolean validTree(int n, int[][] edges) {
        // A valid tree with n nodes must have exactly n - 1 edges
        if (edges.length != n - 1) {
            return false;
        }

        // Build adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        Set<Integer> visited = new HashSet<>();

        // Start DFS from node 0 with parent -1
        if (!dfs(0, -1, adj, visited)) {
            return false;
        }

        // Ensure all nodes are connected
        return visited.size() == n;
    }

    private boolean dfs(int node, int parent, List<List<Integer>> adj, Set<Integer> visited) {
        if (visited.contains(node)) {
            return false; // Cycle detected
        }
        visited.add(node);

        for (int neighbor : adj.get(node)) {
            if (neighbor == parent) {
                continue; // Skip the edge we came from
            }
            if (!dfs(neighbor, node, adj, visited)) {
                return false;
            }
        }
        return true;
    }
}

