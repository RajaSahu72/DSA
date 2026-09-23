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

        // Step 1 - Find size and tail of the ll
        ListNode tail = head;
        int n = 1;
        while(tail.next != null){
            tail = tail.next;
            n++;
        }

        k = k%n;
        if(k == n){
            return head;
        }

        // Step 2 - Make ll circular
        tail.next = head;

        // step 3 - Find newHead and newTail 
        ListNode newTail = head;
        for(int i = 1; i<n-k; i++){
            newTail = newTail.next;
        }
        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }
}