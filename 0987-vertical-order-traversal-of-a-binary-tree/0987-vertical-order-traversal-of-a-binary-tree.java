class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        TreeMap<Integer, List<int[]>> columnTable = new TreeMap<>();
        Queue<Pair<TreeNode, int[]>> queue = new LinkedList<>();

        queue.offer(new Pair<>(root, new int[]{0, 0}));

        while (!queue.isEmpty()) {
            Pair<TreeNode, int[]> pair = queue.poll();
            TreeNode node = pair.getKey();
            int row = pair.getValue()[0];
            int col = pair.getValue()[1];

            columnTable.putIfAbsent(col, new ArrayList<>());
            columnTable.get(col).add(new int[]{row, node.val});

            if (node.left != null)
                queue.offer(new Pair<>(node.left, new int[]{row + 1, col - 1}));
            if (node.right != null)
                queue.offer(new Pair<>(node.right, new int[]{row + 1, col + 1}));
        }

        for (List<int[]> entries : columnTable.values()) {
            Collections.sort(entries, (a, b) -> {
                if (a[0] == b[0]) return Integer.compare(a[1], b[1]);
                return Integer.compare(a[0], b[0]);
            });
            List<Integer> sortedColumn = new ArrayList<>();
            for (int[] entry : entries) {
                sortedColumn.add(entry[1]);
            }
            result.add(sortedColumn);
        }

        return result;
    }
}