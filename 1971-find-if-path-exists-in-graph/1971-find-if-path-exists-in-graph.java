import java.util.*;

class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        // Step 1: Create adjacency list
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        // Step 2: BFS
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);

        while (!queue.isEmpty()) {
            int node = queue.poll();

            if (node == destination) {
                return true;
            }

            if (!visited[node]) {
                visited[node] = true;

                for (int neighbor : graph.get(node)) {
                    if (!visited[neighbor]) {
                        queue.add(neighbor);
                    }
                }
            }
        }

        return false;
    }
}