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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        dfs(root, new StringBuilder(), result);
        return result;
    }
    
    private void dfs(TreeNode node, StringBuilder path, List<String> result) {
        int lengthBefore = path.length();
        
        // Add current node value to path
        if (path.length() == 0) {
            path.append(node.val);
        } else {
            path.append("->").append(node.val);
        }
        
        // If it's a leaf node, add the path to result
        if (node.left == null && node.right == null) {
            result.add(path.toString());
        } else {
            // Continue DFS on children
            if (node.left != null) {
                dfs(node.left, path, result);
            }
            if (node.right != null) {
                dfs(node.right, path, result);
            }
        }
        
        // Backtrack: remove the current node from path
        path.setLength(lengthBefore);
    }
}