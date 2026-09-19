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
        ListNode mid = findMid(head);

        ListNode prev = null;
        ListNode curr = mid.next;
        mid.next = null;

        ListNode next;

        while(curr != null){
            next = curr.next;
            curr.next = prev;

            prev = curr;
            curr = next;
        }

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

    private ListNode findMid(ListNode head){
        ListNode slow = head;
        ListNode fast = head.next;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}