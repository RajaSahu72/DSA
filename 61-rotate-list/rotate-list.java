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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null){
            return head;
        }
        // Step 1 -> Find length and tail of the LL
        ListNode tail = head;
        int n = 1;

        while(tail.next != null){
            tail = tail.next;
            n++;
        }

        // Avoid unneccesary condtions
        k = k % n;
        if(k == 0) return head;

        // Step 2 -> Make the LL circular
        tail.next = head;

        // Step 3 -> Find newTail & newHead
        ListNode newTail = head;

        for(int i = 1; i< n-k; i++){
            newTail = newTail.next;
        }

        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }
}