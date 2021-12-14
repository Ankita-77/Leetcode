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
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) { // return 0 if root is null
            return 0; 
        }
        int sum = 0;
        if (root.val >= low && root.val <= high) {
            sum += root.val; // if current value <= high and >= low then add it 
        }
        if (root.val > low) { // root.val > low then we can travel left part of BST
            // As left of BST is small in value from current value
            sum += rangeSumBST(root.left, low, high);
        }
        if (root.val < high) { // root.val < high then we can travel right part of BST
            // as right of BST is greater than current value
            sum += rangeSumBST(root.right, low, high);
        }
        return sum;
    }
}