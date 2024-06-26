// https://leetcode.com/problems/palindrome-linked-list

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
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        
        
        
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            
            ListNode next = slow.next;
            slow.next=prev;
            prev=slow;
            slow = next;
        }
        
        if(fast!=null){//odd
            slow=slow.next;    
        } 
        
        
        
        
        while(prev!=null){
            if(prev.val!=slow.val)
                return false;
            prev= prev.next;
            slow=slow.next;
        }
            
        
        return true;
        
    }
}