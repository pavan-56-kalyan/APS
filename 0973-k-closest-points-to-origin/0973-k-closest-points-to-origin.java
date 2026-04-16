import java.util.*;

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        
        // Max heap based on distance
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> (b[0]*b[0] + b[1]*b[1]) - (a[0]*a[0] + a[1]*a[1])
        );

        for (int[] point : points) {
            pq.add(point);

            if (pq.size() > k) {
                pq.poll(); // remove farthest
            }
        }

        int[][] result = new int[k][2];

        for (int i = k - 1; i >= 0; i--) {
            result[i] = pq.poll();
        }

        return result;
    }
}