class Solution {
    public String longestNiceSubstring(String s) {
        return helper(s, 0, s.length());
    }

    private String helper(String s, int start, int end) {
        if (end - start < 2) return "";

        int[] lower = new int[26];
        int[] upper = new int[26];

        // Count frequency
        for (int i = start; i < end; i++) {
            char c = s.charAt(i);
            if (Character.isLowerCase(c)) {
                lower[c - 'a']++;
            } else {
                upper[c - 'A']++;
            }
        }

        // Find bad character
        for (int i = start; i < end; i++) {
            char c = s.charAt(i);

            if (Character.isLowerCase(c)) {
                if (upper[c - 'a'] == 0) {
                    String left = helper(s, start, i);
                    String right = helper(s, i + 1, end);
                    return left.length() >= right.length() ? left : right;
                }
            } else {
                if (lower[c - 'A'] == 0) {
                    String left = helper(s, start, i);
                    String right = helper(s, i + 1, end);
                    return left.length() >= right.length() ? left : right;
                }
            }
        }

        return s.substring(start, end);
    }
}