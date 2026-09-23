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
        //Step 1 - Find the length of the ll
        ListNode temp = head;
        int size = 0;

        while(temp != null){
            temp = temp.next;
            size++;
        }
        if(size == n){
            return head.next;
        }

        // Step 2 - Reach to the prev node 
        ListNode prev = head;
        for(int i = 1; i<size-n; i++){
            prev = prev.next;
        }

        // step 3 - remove the nth node 
        prev.next = prev.next.next;

        return head;


    }
}