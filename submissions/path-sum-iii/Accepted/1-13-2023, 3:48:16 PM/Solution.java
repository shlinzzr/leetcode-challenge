// https://leetcode.com/problems/path-sum-iii

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
    
    int cnt;
    
    public int pathSum(TreeNode root, int targetSum) { //https://www.youtube.com/watch?v=3UaqfofZGVM
        cnt =0;
        helper(root, new ArrayList<>(), targetSum);
        return cnt;
    }
    
    private void helper(TreeNode root, ArrayList<Integer> list, int targetSum){
        if(root==null)
            return;
        
        list.add(0, root.val); //關鍵在於從尾巴往前加
        long sum=0;
        for(int i: list){
            sum+=i;
            if(sum==targetSum)
                cnt++;
        }
        
        helper(root.left, list, targetSum);
        helper(root.right, list, targetSum);
        
        list.remove(0);
    }
}