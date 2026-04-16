import java.util.*;

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, String> parent = new HashMap<>();
        Map<String, String> owner = new HashMap<>();

        // Step 1: Initialize
        for (List<String> acc : accounts) {
            String name = acc.get(0);
            for (int i = 1; i < acc.size(); i++) {
                String email = acc.get(i);
                parent.put(email, email);
                owner.put(email, name);
            }
        }

        // Step 2: Union emails in same account
        for (List<String> acc : accounts) {
            String firstEmail = acc.get(1);
            for (int i = 2; i < acc.size(); i++) {
                union(parent, firstEmail, acc.get(i));
            }
        }

        // Step 3: Group emails by root
        Map<String, TreeSet<String>> groups = new HashMap<>();

        for (String email : parent.keySet()) {
            String root = find(parent, email);
            groups.computeIfAbsent(root, k -> new TreeSet<>()).add(email);
        }

        // Step 4: Build result
        List<List<String>> result = new ArrayList<>();

        for (String root : groups.keySet()) {
            List<String> list = new ArrayList<>();
            list.add(owner.get(root)); // name
            list.addAll(groups.get(root)); // sorted emails
            result.add(list);
        }

        return result;
    }

    private String find(Map<String, String> parent, String x) {
        if (!parent.get(x).equals(x)) {
            parent.put(x, find(parent, parent.get(x))); // path compression
        }
        return parent.get(x);
    }

    private void union(Map<String, String> parent, String x, String y) {
        String px = find(parent, x);
        String py = find(parent, y);
        if (!px.equals(py)) {
            parent.put(px, py);
        }
    }
}