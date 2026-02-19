public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // If both nodes are null, they are the same
        if (p == null && q == null) return true;
        
        // If one of them is null, they are not the same
        if (p == null || q == null) return false;
        
        // Check if the current nodes have the same value
        if (p.val != q.val) return false;
        
        // Recursively check left and right subtrees
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}