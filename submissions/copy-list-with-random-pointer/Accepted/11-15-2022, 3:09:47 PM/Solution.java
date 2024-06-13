// https://leetcode.com/problems/copy-list-with-random-pointer

/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        
        
        
        
        if(head==null)
            return null;
        
        
        Map<Node, Node> map = new HashMap<>();
        
        Node node = new Node(head.val);
        Node res = node;
        Node curr = head;
        
        while(curr!=null){
            
            
            map.put(curr, node);
            
            if(curr.next!=null){
                node.next = new Node(curr.next.val);
                
            }
            node = node.next;
            curr = curr.next;
        }
        
        node=res;
        curr=head;
        while(curr!=null){
            
            if(curr.random!=null){
                node.random=map.get(curr.random);
            }
            node = node.next;
            curr=curr.next;
        }
        
        return res;
    }
}