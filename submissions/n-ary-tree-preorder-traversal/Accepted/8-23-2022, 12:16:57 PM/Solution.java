// https://leetcode.com/problems/n-ary-tree-preorder-traversal

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> res =new ArrayList<>();
        helper(res, root);
        return res;
    }
    
    private void helper(List<Integer> res, Node root){
        if(root==null)
            return;
        
        
        res.add(root.val);
        
        for(Node child : root.children){
            helper(res, child);    
        }
        
        
    }
}