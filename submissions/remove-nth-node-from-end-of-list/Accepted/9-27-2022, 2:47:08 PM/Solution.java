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
        HashMap<Integer, ListNode> map = new HashMap<>();
        
        int idx =0;
        
        ListNode cur = head;
        while(cur!=null){
            map.put(idx, cur);
            idx++;
            cur = cur.next;
        }
        
        int len = idx;
        
        ListNode prev = map.get(len-n-1);
        if(prev==null)
            head = head.next;
        else{
            prev.next = prev.next.next;
        }
        
        return head;
        
    }
}