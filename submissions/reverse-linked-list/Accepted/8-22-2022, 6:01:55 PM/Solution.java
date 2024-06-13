// https://leetcode.com/problems/reverse-linked-list

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
    public ListNode reverseList(ListNode head) {
        
        ListNode prev = null;
        
        while(head!=null){
            
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            // temp.next = prev;
            head = temp;
            
            
        }
        
        return prev;
    }
}