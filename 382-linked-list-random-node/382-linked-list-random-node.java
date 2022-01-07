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
    
    private int len = 0;
    private ListNode head;

    public Solution(ListNode head) {
        this.head = head;    
    }
    
    public void getLength(ListNode head) {
        if(len == 0) {
            ListNode dummy = head;
            while(dummy != null) {
                len++;
                dummy = dummy.next;
            }
        }
    }
    
    public int getRandom() {
        getLength(head);
        Random rand = new Random();
        int randNum = rand.nextInt(len);
        ListNode dummy = head;
        int result = findRandom(dummy, randNum);
        return result;
    }
    
    public int findRandom(ListNode dummy, int randNum) {
        int num = 0;
        while(num != randNum) {
            num++;
            dummy = dummy.next;
        }
        return dummy.val;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */