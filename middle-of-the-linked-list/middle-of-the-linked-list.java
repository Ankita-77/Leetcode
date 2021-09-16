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
    public ListNode middleNode(ListNode head) {
        int len = length(head);
        
        int mid = len/2;
        ListNode current = head;
        
        while(mid > 0){
            current = current.next;
            mid--;
        }
        
        return current;
    }
    
    public int length(ListNode head){
        int count = 0;
        
        while(head != null){
            head = head.next;
            count++;
        }
        
        return count;
    }
}