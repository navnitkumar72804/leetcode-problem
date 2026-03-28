/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isMirror(root.left, root.right);
    }
    
    private boolean isMirror(TreeNode left, TreeNode right) {
        // Base cases
        if (left == null && right == null) {
            return true; // Both are null
        }
        if (left == null || right == null) {
            return false; // One is null, the other is not
        }
        if (left.val != right.val) {
            return false; // Values don't match
        }
        
        // Recursively check: left's left with right's right, and left's right with right's left
        return isMirror(left.left, right.right) && isMirror(left.right, right.left);
    }
}