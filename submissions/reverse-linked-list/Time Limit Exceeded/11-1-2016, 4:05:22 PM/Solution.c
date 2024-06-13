// https://leetcode.com/problems/reverse-linked-list

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode* reverseList(struct ListNode* head) {
    
    struct ListNode *ptr = NULL;
    struct ListNode *node = head;

    while(node){
        struct ListNode *next = node -> next;
        node -> next = ptr;
        ptr = node;
    }
    
    return node;
    
}