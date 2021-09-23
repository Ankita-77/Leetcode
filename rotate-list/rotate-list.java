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
    public ListNode rotateRight(ListNode head, int k) {
        // edge cases
        if(head == null || head.next == null || k == 0) return head;
        
        ListNode curr = head;
        // find length
        int len = 1;  
        while(curr.next != null){
            curr = curr.next;
            len++;
        }
        
        // go till that node
        curr.next = head;
        k = k % len;
        k = len - k;
        
        while(k-- > 0){
            curr = curr.next;
        }
        
        // make the node head and break connection
        head = curr.next;
        curr.next = null;
        
        return head;
    }
}