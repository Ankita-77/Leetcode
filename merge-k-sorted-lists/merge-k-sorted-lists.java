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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        
        return mergeList(lists, 0, lists.length-1);
    }
    
    public ListNode mergeList(ListNode[] list, int si, int ei){
        if(si > ei) return null;
        
        if(si == ei) return list[si];
        
        int mid = (si + ei) / 2;
        
        ListNode l1 = mergeList(list, si, mid);
        ListNode l2 = mergeList(list, mid+1, ei);
        
        return mergeTwo(l1, l2);
    }
    
    public ListNode mergeTwo(ListNode l1, ListNode l2){
        if(l1 == null || l2 == null) return l1 != null ? l1 : l2;
        
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        
        ListNode c1 = l1;
        ListNode c2 = l2;
        
        while(c1 != null && c2 != null){
            if(c1.val < c2.val){
                prev.next = c1;
                c1 = c1.next;
            }else{
                prev.next = c2;
                c2 = c2.next;
            }
            
            prev = prev.next;
        }
        
        prev.next = c1 != null ? c1 : c2;
        
        return dummy.next;
    }
}