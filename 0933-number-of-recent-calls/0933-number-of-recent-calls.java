class RecentCounter {
    
    private LinkedList<Integer> queue;

    public RecentCounter() {
        queue = new LinkedList<>();
    }
    
    public int ping(int t) {
        // Add the new request
        queue.addLast(t);
        
        // Remove requests older than t - 3000
        while (!queue.isEmpty() && queue.getFirst() < t - 3000) {
            queue.removeFirst();
        }
        
        // Number of requests in the last 3000 ms
        return queue.size();
    }
}


/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */