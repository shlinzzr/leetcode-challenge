// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree

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
        
        if(root==null)
            return root;
        
        if(p.val>root.val && q.val<root.val)
            return root;
        
        if(q.val>root.val && p.val<root.val)
            return root;
        
        if(p.val>root.val && q.val>root.val)
            return lowestCommonAncestor(root.right, p, q);
        
        if(p.val<root.val && q.val<root.val)
            return lowestCommonAncestor(root.left, p, q);
        
        
        return root;
    }
}