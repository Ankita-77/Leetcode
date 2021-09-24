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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        
        ListNode end = list1, start = null;
        
        // locate b upon termination of the loop.
        for(int i=0; i<b; i++, end = end.next){ 
            if(i == a-1){     // locate the node right before a.
                start = end;
            }
        }
        
// connect the node right before a to the head of list2, hence cut off a from list1.
        
        start.next = list2;
        
        while(list2.next != null){  // traverse till the end of list2.
            list2 = list2.next;
        }
        
        // connect end of list2 to the node right after b.
        list2.next = end.next;  
        
        // cut off b from list1.
        end.next = null;
        
        return list1;
    }
}