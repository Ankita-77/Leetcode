/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int sum=0;
    public int sumRootToLeaf(TreeNode root) {
        search(root,0);
        return sum;
    }
    
    private void search(TreeNode root,int x){
        if(root==null){
            return;
        }
        
        if(root.left==null && root.right==null){
            sum+=root.val==0?x*2:x*2+1;
            return;
        }
        search(root.left,root.val==0?x*2:x*2+1);
        search(root.right,root.val==0?x*2:x*2+1);
        
    }
}