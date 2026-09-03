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
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode mid = findMid(head);

        ListNode leftH = head;
        ListNode rightH = mid.next;
        mid.next = null;

        ListNode newLeft = sortList(leftH);
        ListNode newRight = sortList(rightH);

        return merge(newLeft, newRight);
    }


    private ListNode merge(ListNode h1, ListNode h2){
        ListNode mergedLL = new ListNode(-1);
        ListNode temp = mergedLL;

        while(h1 != null && h2 != null){
            if(h1.val < h2.val){
                temp.next = h1;
                h1 = h1.next;
            }
            else{
                temp.next = h2;
                h2 = h2.next;
            }
            temp = temp.next;
        }

        while(h1 != null){
            temp.next = h1;
            h1 = h1.next;
            temp = temp.next;
        }

        while(h2 != null){
            temp.next = h2;
            h2 = h2.next;
            temp = temp.next;
        }

        return mergedLL.next;
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