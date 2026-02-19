class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char task : tasks) {
            freq[task - 'A']++;
        }
        
        Arrays.sort(freq);
        int maxFreq = freq[25]; // highest frequency
        int numMaxFreqTasks = 0;
        
        // Count how many tasks have the maximum frequency
        for (int i = 25; i >= 0; i--) {
            if (freq[i] == maxFreq) {
                numMaxFreqTasks++;
            } else {
                break;
            }
        }
        
        // Calculate minimum intervals
        int intervals = (maxFreq - 1) * (n + 1) + numMaxFreqTasks;
        return Math.max(tasks.length, intervals);
    }
}