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

        // Step1 - Find the mid
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode mid = slow;


        // Step2 - Reverse 2nd half
        ListNode curr = mid.next;
        mid.next = null;
        ListNode prev = null;

        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;

            prev = curr;
            curr = next;
        }

        // Alternate Merge
        ListNode leftHead = head;
        ListNode rightHead = prev;
        ListNode nextLeft;
        ListNode nextRight;
        
        while(leftHead != null && rightHead != null){
            nextLeft = leftHead.next;
            leftHead.next = rightHead;

            nextRight = rightHead.next;
            rightHead.next = nextLeft;

            leftHead = nextLeft;
            rightHead = nextRight;
        }

    }
}