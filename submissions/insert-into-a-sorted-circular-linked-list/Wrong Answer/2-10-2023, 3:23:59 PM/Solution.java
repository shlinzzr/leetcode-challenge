// https://leetcode.com/problems/insert-into-a-sorted-circular-linked-list

/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};
*/

class Solution {
    public Node insert(Node head, int insertVal) {
        if(head==null){
            Node node = new Node(insertVal);
            node.next = node;
            return node;
        }
        
        Node prev = head;
        Node next = head.next;
        
        while(true){
            if(prev.val<=insertVal && insertVal<=next.val){
                break;
                
            }else if(prev.val>next.val && (insertVal>prev.val || insertVal<next.val)){
                break;
            }
            
            prev=prev.next;
            next=next.next;
                
            if(prev.val==head.val)
                break;
        }
        
        Node node = new Node(insertVal);
        prev.next = node;
        node.next = next;
        
        return head;
        
    }
}