// https://leetcode.com/problems/sort-list

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
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)	
            return head;	
        
        
        ListNode fast=head, slow=head, prev=null;
        while(fast!=null && fast.next!=null){
            prev=slow;
            fast=fast.next.next;
            slow=slow.next;
        }
        if(prev!=null)
            prev.next=null;
        
        ListNode left = sortList(head);
        ListNode right = sortList(slow);
        ListNode res = mergeHalves(left, right);
        
        return res;
    }
    
    
    private ListNode mergeHalves(ListNode left, ListNode right){
        
        ListNode dummy = new ListNode();
        ListNode curr = dummy;
        while(left!=null && right!=null){
            
            if(left.val<=right.val){
                
                ListNode node = new ListNode(left.val);
                curr.next = node;
                left=left.next;
            }else{
                ListNode node = new ListNode(right.val);
                curr.next = node;
                right=right.next;
            }
            
            curr=curr.next;
        }
        
        while(left!=null){
            
            ListNode node = new ListNode(left.val);
            curr.next = node;
            left=left.next;
            curr=curr.next;
        }
        
        while(right!=null){
            ListNode node = new ListNode(right.val);
            curr.next = node;
            right=right.next;
            curr=curr.next;
        }
        
        return dummy.next;
    }
}