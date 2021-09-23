/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        int len1 = length(headA);
        int len2 = length(headB);
        
        int diff = len2 > len1 ? len2-len1 : len1-len2;
        
        ListNode dummyA = headA;
        ListNode dummyB = headB;
        
        for(int i=1; i<=diff; i++){
            if(len1 > len2){
                dummyA = dummyA.next;
            }else{
                dummyB= dummyB.next;
            }
        }
        
        while(dummyA != null){
            
            while(dummyA != dummyB){
                dummyA = dummyA.next;
                dummyB = dummyB.next;
             }
            
            return dummyA;
        }
        
        return null;
    }
    
    public int length(ListNode head){
        int len = 0;
        ListNode curr = head;
        
        while(curr != null){
            curr = curr.next;
            len++;
        }
        
        return len;
    }
}