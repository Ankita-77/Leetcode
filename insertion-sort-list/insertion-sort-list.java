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
    public ListNode insertionSortList(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode curr = head.next;
        ListNode newHead = head;
        newHead.next = null;
        while (curr != null) {
            ListNode next = curr.next;
            ListNode node = newHead;
            ListNode prev = null;
            while (node != null) {
                if (curr.val <= newHead.val) {
                    curr.next = newHead;
                    newHead = curr;
                    break;
                }
                if (curr.val <= node.val) {
                    prev.next = curr;
                    curr.next = node;
                    break;
                }
                prev = node;
                node = node.next;
            }
            if (node == null) {
                prev.next = curr;
                curr.next = null;
            }
            curr = next;
        }
        return newHead;
    }
}