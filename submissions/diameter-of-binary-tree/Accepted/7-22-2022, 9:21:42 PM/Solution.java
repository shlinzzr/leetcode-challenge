// https://leetcode.com/problems/diameter-of-binary-tree

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
    int max=0;
    
    public int diameterOfBinaryTree(TreeNode root) {
        int dia = maxDepth(root);
        
        return max;
    }
    
     private int maxDepth(TreeNode root) {
        if (root == null) return 0;
        
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        
        max = Math.max(max, left + right);
        
        return Math.max(left, right) + 1;
    }
    
    
    private int findDepth(TreeNode root, int d){
        
        if(root==null)
            return d;
        
        d++;
        return Math.max(findDepth(root.left, d), findDepth(root.right, d));
        
    }
}