// https://leetcode.com/problems/all-elements-in-two-binary-search-trees

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
    
    
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list =new ArrayList<>();    
        
        Stack<TreeNode> stack1 =new Stack<>();
        Stack<TreeNode> stack2 =new Stack<>();
        
        while(root1!=null || root2!=null || !stack1.isEmpty() || !stack2.isEmpty()){
            
            if(root1!=null){
                stack1.push(root1);
                root1 = root1.left;
                
            }else if(root2!=null){
                stack2.push(root2);
                root2 = root2.left;
                
            }else if(stack2.isEmpty() || stack1.peek().val<=stack2.peek().val){
                root1 = stack1.pop();
                list.add(root1.val);
                root1 = root1.right;
                
            }else{
                root2 = stack2.pop();
                list.add(root2.val);
                root2 = root2.right;
            }
            
            
            
        }
        
        
        return list;
       
        
        
        
        
    }
    
    
}