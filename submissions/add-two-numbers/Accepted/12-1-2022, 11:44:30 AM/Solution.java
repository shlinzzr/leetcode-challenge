// https://leetcode.com/problems/add-two-numbers

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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode dummy = new ListNode();
        ListNode curr = dummy;
        int carry=0;
        
        while(l1!=null || l2!=null || carry==1){
            
            ListNode next = new ListNode();
            
            int sum = carry;
            
            if(l1!=null){
                sum+=l1.val;
                l1=l1.next;
            }
            
            if(l2!=null){
                sum+=l2.val;
                l2=l2.next;
            }
            
            next.val=sum%10;
            carry = sum/10;
            
            curr.next = next;
            curr=curr.next;
        }
        
        return dummy.next;
        
    }
}