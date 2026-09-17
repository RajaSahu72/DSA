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
    public ListNode partition(ListNode head, int x) {
        ListNode smallDummy = new ListNode(-1);
        ListNode largeDummy = new ListNode(-1);

        ListNode small = smallDummy;
        ListNode large = largeDummy;

        ListNode temp = head;

        while(temp != null){
            if(temp.val < x){
                small.next = temp;
                small = small.next;
            }
            else{
                large.next = temp;
                large = large.next;
            }
            temp = temp.next;
        }

        large.next = null;
        small.next = largeDummy.next;

        return smallDummy.next;
    }
}