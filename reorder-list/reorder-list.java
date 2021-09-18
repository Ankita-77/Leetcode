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
        if(head == null || head.next == null) return;
        
        ListNode mid = findMid(head);
        ListNode nHead = mid.next;
        mid.next = null;
        
        nHead = reverseLL(nHead);
        
        ListNode c1 = head;
        ListNode c2 = nHead;
        ListNode f1 = null;
        ListNode f2 = null;
        
        while(c2 != null){
            // backup
            f1 = c1.next;
            f2 = c2.next;
            
            //links
            c1.next = c2;
            c2.next = f1;
            
            //move
            c1 = f1;
            c2 = f2;
        }
    }
    
    public ListNode findMid(ListNode head){  
        if(head == null || head.next == null) return head;
        
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }
    
    public ListNode reverseLL(ListNode head){
        if(head == null || head.next == null) return head;
        
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;
        
        while(curr != null){
            next = curr.next;
            
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        return prev;
    }
}

// time = O(N)
// Space = O(1)