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
        /*=============== One Pass Approach ===================== */

        // Step 1 - Find kth node from the begining
        ListNode first = head;
        for(int i = 1; i<k; i++){
            first = first.next;
        }

        // Step 2 - Find kth node from the end
        ListNode fast = first;
        ListNode second = head;

        while(fast.next != null){
            fast = fast.next;
            second = second.next;
        }

        // Swapping Values
        int temp = first.val;
        first.val = second.val;
        second.val = temp;

        return head;
    }
}