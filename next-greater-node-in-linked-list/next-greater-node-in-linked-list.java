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
    public int[] nextLargerNodes(ListNode head) {
        ArrayList<Integer> A = new ArrayList<>();
        
        ListNode curr = head;
        while(curr != null){
            A.add(curr.val);
            curr = curr.next;
        }
        
        int n = A.size();
        int res[] = new int[n];
        Stack<Integer> st = new Stack<>();
        
        for(int i=n-1; i>=0; i--){
            while(st.size() > 0 && A.get(i) >= st.peek()){
                st.pop();
            }
            
            if(st.size() == 0){
                res[i] = 0;
            }else{
                res[i] = st.peek();
            }
            
            st.push(A.get(i));
        }
        
        return res;
        
    }
}