// https://leetcode.com/problems/clone-graph

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    
    public HashMap<Integer, Node> map = new HashMap<>();
    
    
    public Node cloneGraph(Node node) {
        
        if(node==null)
            return null;
        
        if(map.containsKey(node.val))
            return map.get(node.val);
        
        Node nn = new Node(node.val, new ArrayList<>());
        map.put(nn.val, nn);
        for(Node n : node.neighbors){
            nn.neighbors.add(cloneGraph(n));
        }
        
        return nn;
        
    }
}