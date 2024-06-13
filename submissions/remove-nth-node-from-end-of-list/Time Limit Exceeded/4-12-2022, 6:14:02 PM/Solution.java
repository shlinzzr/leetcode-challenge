// https://leetcode.com/problems/remove-nth-node-from-end-of-list

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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int cnt = 1;
        
        ListNode tmp =head;
        while(tmp.next!=null){
            
            tmp = head.next;
            cnt++;
        }
        System.out.println(cnt);
        
        
        int step = 1;
        tmp= head;
        while(step<=cnt-n){
            tmp = head.next;
            step++;
        }
        
        if(tmp.next!=null){
            if(tmp.next.next!=null){
                tmp.next = tmp.next.next;
            }else{
                tmp.next=null;
            }
        }
        return head;
            
    }
}