class Solution {

    public boolean validTree(int n, int[][] edges) {

        // A tree with n nodes must have n - 1 edges
        if (edges.length != n - 1) {
            return false;
        }

        // Build adjacency list
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        boolean[] visited = new boolean[n];

        // Start DFS from node 0
        if (hasCycle(graph, 0, -1, visited)) {
            return false;
        }

        // Check whether every node was visited
        for (boolean nodeVisited : visited) {
            if (!nodeVisited) {
                return false;
            }
        }

        return true;
    }

    private boolean hasCycle(
            List<List<Integer>> graph,
            int node,
            int parent,
            boolean[] visited) {

        visited[node] = true;

        for (int neighbor : graph.get(node)) {

            // Ignore the edge we came from
            if (neighbor == parent) {
                continue;
            }

            // Already visited and not parent => cycle
            if (visited[neighbor]) {
                return true;
            }

            if (hasCycle(graph, neighbor, node, visited)) {
                return true;
            }
        }

        return false;
    }
}
