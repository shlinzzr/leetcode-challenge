// https://leetcode.com/problems/all-possible-full-binary-trees

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
    public List<TreeNode> allPossibleFBT(int n) {
      
      
        List<TreeNode> res= new ArrayList<>();
        if(n<=0 || n%2==0) return new ArrayList<>();
       
        if(n==1){
            res.add( new TreeNode(0));
            return res;
        }
        
        for(int i=1; i<n; i+=2){
            List<TreeNode> left = allPossibleFBT(i);
            List<TreeNode> right = allPossibleFBT(n-i-1);
            
            for(TreeNode l : left){
                for(TreeNode r: right){
                    TreeNode node = new TreeNode(0);
                    node.left = l;
                    node.right = r;
                    res.add(node);
                }
            }
        }
        
        return res;
    }
    
}