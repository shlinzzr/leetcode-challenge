// https://leetcode.com/problems/delete-leaves-with-a-given-value

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
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if(root==null)
            return null;        
        
        root.left=removeLeafNodes(root.left, target);
        root.right=removeLeafNodes(root.right, target);
        if(root.left==null && root.right==null && root.val==target)
            return null;

        return root;
        
    }
    
    
//     private void helper( TreeNode root, int target){
        
//         if(root==null)
//             return;
        
//         if(root.left!=null&&root.left.left==null &&root.left.right==null && root.left.val==target)
//             root.left=null;
        
//         if(root.right!=null&&root.right.left==null &&root.right.right==null && root.right.val==target)
//             root.right=null;
        
//         if(root.left==null && root.right==null){
//             helper(root)
//         }
        
        
        
//         helper(root.left, target);
//         helper(root.right, target);
                
            
        
        
//     }
}