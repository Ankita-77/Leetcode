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
        ListNode slow = head;
        ListNode fast = head;
        
        // move till the kth node from beginning
        for(int i=1; i<k; i++){
            fast = fast.next;
        }
        
        // Save first node for swapping
        ListNode first = fast;
        
        // move till the end at this point slow will be at kth node from              the end
        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        
        // save second node for swapping
        ListNode second = slow;
        
        // swap
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
        
        return head;
    }
}