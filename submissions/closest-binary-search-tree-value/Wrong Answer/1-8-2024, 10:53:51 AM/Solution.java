// https://leetcode.com/problems/closest-binary-search-tree-value

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

    int cur = Integer.MIN_VALUE/2;
    double offset = Double.MAX_VALUE;

    public int closestValue(TreeNode root, double target) {
        
        if(root==null) return Integer.MAX_VALUE;

        if(Math.abs(target-cur)<offset){
            offset = target-root.val;
            cur = root.val;
        }

        if(target==root.val) return 0;
        if(target<root.val)
            closestValue(root.left, target);
        else 
             closestValue(root.right, target);

        return cur;
    }
}