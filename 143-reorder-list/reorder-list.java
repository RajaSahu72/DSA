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
    public void reorderList(ListNode head) {

        // Step 1 - Find mid
        ListNode slow = head;
        ListNode fast = head.next;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode mid = slow;

        // Step 2 - Reverse Second half
        ListNode prev = null;
        ListNode curr = mid;
        ListNode next;

        while(curr != null){
            next = curr.next;
            curr.next = prev;

            prev = curr;
            curr = next;
        }

        // Alternative Merge
        ListNode lH = head;
        ListNode rH = prev;
        ListNode nextL, nextR;

        while(lH != null && rH != null){
            nextL = lH.next;
            lH.next = rH;

            nextR = rH.next;
            rH.next = nextL;

            lH = nextL;
            rH = nextR;
        }

    }
}