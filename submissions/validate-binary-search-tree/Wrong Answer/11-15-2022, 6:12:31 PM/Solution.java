// https://leetcode.com/problems/validate-binary-search-tree

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
    public boolean isValidBST(TreeNode root) {
        
        if(root==null)
            return true;
        
        if(root.left!=null && root.left.val>=root.val)
            return false;
        
        if(root.right!=null && root.val>=root.right.val)
            return false;
        
        boolean bl = isValidBST(root.left);
        boolean br = isValidBST(root.right);
        
        return bl & br;
        
    }
}