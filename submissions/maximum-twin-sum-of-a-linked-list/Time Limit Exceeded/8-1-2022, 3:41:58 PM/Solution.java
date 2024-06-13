// https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int pairSum(ListNode head) {
        
        int len = 0;
        
        ListNode newHead = new ListNode(head.val, head.next);
        
        while(newHead!=null){
            newHead=newHead.next;
            len++;
        }
        
        int max = 0;
        for(int i=0; i<len/2; i++){
            int val = getVal(head, i) + getVal(head, len-i-1);
            max = Math.max(max, val);
            
        }
        
        return max;
        
    }
    
    
    private int getVal(ListNode head, int idx){
        ListNode newHead = new ListNode(head.val, head.next);
        
        while(idx>0){
            newHead = newHead.next;
            idx--;
        }
        
        return newHead.val;
        
    }
    
    
}