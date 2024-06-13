// https://leetcode.com/problems/binary-tree-maximum-path-sum

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
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        getDepth(root);
        return max;
        
    }
    
    private int getDepth(TreeNode root){
        
        if(root==null) return 0;
        
        int val = 0;
        if(root.val>0) val+=root.val;
        
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        
        if(left>0) val+= left;
        if(right>0) val+=right;
        
        max = Math.max(max, val);
        
        return Math.max(left, right)+root.val;
        
    }
}