// https://leetcode.com/problems/binary-tree-preorder-traversal

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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        
        Stack<TreeNode> stack = new Stack<>();
        
        TreeNode curr = root;
        while(curr!=null || !stack.isEmpty()){
            
            while(curr!=null){
                list.add(curr.val);
                stack.push(curr);
                curr = curr.left;
            }
            
            curr = stack.pop();
            // list.add(curr.val);
            curr = curr.right;
        }
        
        return list;
        
    } 
}