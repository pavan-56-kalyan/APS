import java.util.*;

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(1, n, k, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int start, int n, int k,
                           List<Integer> temp,
                           List<List<Integer>> result) {

        // base case
        if (temp.size() == k) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = start; i <= n; i++) {
            temp.add(i);                      // choose
            backtrack(i + 1, n, k, temp, result); // move forward
            temp.remove(temp.size() - 1);     // backtrack
        }
    }
}