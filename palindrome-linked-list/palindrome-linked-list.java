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
         
         ListNode mid = middle(head);
         ListNode nHead = mid.next;
         mid.next = null;
         
         nHead = reverseLL(nHead);
         
         ListNode c1 = head;
         ListNode c2 = nHead;
         
         boolean res = true;
         
         while(c2 != null){
             if(c1.val != c2.val){
                 res = false;
                 break;
             }
             
             c1 = c1.next;
             c2 = c2.next;
         }
         
         nHead = reverseLL(nHead);
         mid.next = nHead;
         
         return res;
    }
    
     public ListNode middle(ListNode head){
        if(head == null || head.next == null) return head;
        
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }
    
    public  ListNode reverseLL(ListNode head){
        if(head == null || head.next == null) return head;
        
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