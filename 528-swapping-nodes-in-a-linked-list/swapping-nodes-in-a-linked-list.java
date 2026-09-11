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
    public ListNode swapNodes(ListNode head, int k) {

        // Step 1 - Find length of the LL
        ListNode curr = head;
        int size = 0;
        while(curr != null){
            curr = curr.next;
            size++;
        }

        // Step 2 - Find kth node from begining
        ListNode first = head;
        for(int i = 1; i<k; i++){
            first = first.next;
        }

        // Step 3 - Find kth node from end
        ListNode second = head;
        for(int i = 1; i<size-k+1; i++){
            second = second.next;
        }

        // Step 4 - Swap values
        int temp = first.val;
        first.val = second.val;
        second.val = temp;

        return head;
    }
    
}