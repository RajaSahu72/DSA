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
        
        //Calculate the length of the LL
        int length = 1;
        ListNode tail = head;
        while(tail.next != null){
            length++;
            tail = tail.next;
        }

        if(k % length == 0) return head;

        k = k % length;

        // Making list circular
        tail.next = head;

        //Find the newTail and newHead
        int stepsToNewHead = length - k;
        ListNode newTail = head;
        for(int i = 1; i<stepsToNewHead; i++){
            newTail = newTail.next;
        }
        
        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }
}