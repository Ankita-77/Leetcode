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
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        
        ListNode mid = mid(head);
        ListNode nHead = mid.next;
        mid.next = null;
        
        nHead = reverse(nHead);
        
        ListNode c1 = head;
        ListNode c2 = nHead;
         
        while(c2 != null){
             if(c1.val != c2.val){
                 return false;
             }
             
             c1 = c1.next;
             c2 = c2.next;
        }
        
        return true;
        
    }
    
    public ListNode mid(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }
    
    
    public ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        
        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        return prev;
    }
}