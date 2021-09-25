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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        ListNode slow = head, fast = head;
        
        //maintain distance
        for(int i=1; i<=n; i++){
            fast = fast.next;
            
            if (fast == null) return head.next;
        }
        
        //Move fast to the end, maintaining the gap
        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        
        // skip the desired node
        slow.next = slow.next.next;
        
        return head;
    }
}