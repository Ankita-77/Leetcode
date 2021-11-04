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
    public int maxDepth(TreeNode root) {
        // RECURSIVE
        if(root == null) return 0;
        
        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);
        
        return 1 + Math.max(leftHeight , rightHeight);
        
        
// LEVEL ORDER TRAVERSAL
//         if(root == null){
//            return 0;
//         }
        
//         Queue<TreeNode> queue = new LinkedList<>();
//         queue.offer(root);
//         int count = 0;
//         while(!queue.isEmpty()){
//             int size = queue.size();
//             while(size-- > 0) {
//                 TreeNode node = queue.poll();
//                 if(node.left != null){
//                     queue.offer(node.left);
//                 }
//                 if(node.right != null){
//                     queue.offer(node.right);
//                 }
//             }
//             count++;
//         }
        
//         return count;
        
    }
}