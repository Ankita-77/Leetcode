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
    public int findTilt(TreeNode root) {
        int ans[] = helper(root);
        return ans[1];
    }
    public int[] helper(TreeNode root){
        if(root == null)return new int[2];
        int[] left = helper(root.left);
        int[] right = helper(root.right);
        int[] res = new int[2];
        res[0] = left[0] + right[0] + root.val;
        res[1] = Math.abs(left[0] - right[0]) +left[1]+ right[1];
        return res;
    }
}