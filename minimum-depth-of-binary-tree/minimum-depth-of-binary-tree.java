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
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        
        int leftHeight = minDepth(root.left);
        int rightHeight = minDepth(root.right);
        
        return (leftHeight == 0 || rightHeight == 0) ? leftHeight + rightHeight                 + 1:Math.min(leftHeight,rightHeight) + 1;
    }
}