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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        
        // TreeMap to store column -> (row -> list of values)
        // Using TreeMap to maintain columns in sorted order
        TreeMap<Integer, TreeMap<Integer, List<Integer>>> map = new TreeMap<>();
        
        // BFS traversal with queue storing node, row, column
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0, 0));
        
        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            TreeNode node = current.node;
            int row = current.row;
            int col = current.col;
            
            // Add to map
            map.putIfAbsent(col, new TreeMap<>());
            map.get(col).putIfAbsent(row, new ArrayList<>());
            map.get(col).get(row).add(node.val);
            
            // Process children
            if (node.left != null) {
                queue.offer(new Pair(node.left, row + 1, col - 1));
            }
            if (node.right != null) {
                queue.offer(new Pair(node.right, row + 1, col + 1));
            }
        }
        
        // Build result from map
        for (TreeMap<Integer, List<Integer>> rows : map.values()) {
            List<Integer> columnList = new ArrayList<>();
            for (List<Integer> values : rows.values()) {
                // Sort values for the same row and column
                Collections.sort(values);
                columnList.addAll(values);
            }
            result.add(columnList);
        }
        
        return result;
    }
    
    // Helper class to store node with its position
    private class Pair {
        TreeNode node;
        int row;
        int col;
        
        Pair(TreeNode node, int row, int col) {
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }
}