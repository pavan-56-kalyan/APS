import java.util.*;

class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        
        // Step 1: Build graphs
        List<List<Integer>> redGraph = new ArrayList<>();
        List<List<Integer>> blueGraph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            redGraph.add(new ArrayList<>());
            blueGraph.add(new ArrayList<>());
        }

        for (int[] e : redEdges) {
            redGraph.get(e[0]).add(e[1]);
        }

        for (int[] e : blueEdges) {
            blueGraph.get(e[0]).add(e[1]);
        }

        // Step 2: Initialize result
        int[] result = new int[n];
        Arrays.fill(result, -1);

        // Step 3: BFS
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][2];

        // Start with both colors
        queue.add(new int[]{0, 0}); // last red
        queue.add(new int[]{0, 1}); // last blue
        visited[0][0] = true;
        visited[0][1] = true;

        int distance = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                int node = curr[0];
                int color = curr[1];

                // Update result
                if (result[node] == -1) {
                    result[node] = distance;
                }

                // Alternate color
                if (color == 0) { // last red → use blue
                    for (int next : blueGraph.get(node)) {
                        if (!visited[next][1]) {
                            visited[next][1] = true;
                            queue.add(new int[]{next, 1});
                        }
                    }
                } else { // last blue → use red
                    for (int next : redGraph.get(node)) {
                        if (!visited[next][0]) {
                            visited[next][0] = true;
                            queue.add(new int[]{next, 0});
                        }
                    }
                }
            }

            distance++;
        }

        return result;
    }
}