/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode current = root;
        
        while (current != null) {
            // If both p and q are greater than current, go right
            if (p.val > current.val && q.val > current.val) {
                current = current.right;
            }
            // If both p and q are less than current, go left
            else if (p.val < current.val && q.val < current.val) {
                current = current.left;
            }
            // Otherwise, current is the LCA (one on left, one on right, or current equals one of them)
            else {
                return current;
            }
        }
        
        return null;
    }
}