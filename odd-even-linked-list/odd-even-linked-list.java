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
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode fh = head;
        ListNode fp = head;
        
        ListNode sh = head.next;
        ListNode sp = head.next;
        
        while(sp != null && sp.next != null){
            ListNode f = sp.next;
            
            fp.next = f;
            sp.next = f.next;
            
            fp = fp.next;
            sp = sp.next;
        }
        
        fp.next = null;
        fp.next = sh;
        
        return fh;
    }
}