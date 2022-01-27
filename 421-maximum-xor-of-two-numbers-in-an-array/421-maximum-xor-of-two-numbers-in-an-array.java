class TrieNode{
    TrieNode [] next;
    public TrieNode(){
        next = new TrieNode[2];
        Arrays.fill(next,null);
    }
}

class Solution {
    TrieNode root = new TrieNode();
    int max = Integer.MIN_VALUE;
    public int findMaximumXOR(int[] nums) {
        for (int num : nums){
            insert(num,root);
            max = Math.max(max,maxXor(num,root));
        }
        return max;
    }

    public void insert(int num , TrieNode root){
        TrieNode curr = root;
        for (int i=31;i>=0;i--){
            int bit = (num >> i) & 1;
            if (curr.next[bit] == null){
                curr.next[bit] = new TrieNode();
            }
            curr = curr.next[bit];
        }
    }

    public int maxXor(int num , TrieNode root){
        TrieNode curr = root;
        int ans = 0;
        for (int i=31;i>=0;i--){
            int bit = (num>>i)&1;
            if (curr.next[bit==0 ? 1 : 0] != null) {
                ans = ans + (1 << i);
                curr = curr.next[bit==0 ? 1 : 0];
            }else {
                curr = curr.next[bit==0 ? 0 : 1];
            }
        }
        return ans;
    }
}