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
    public List<Integer> postorderTraversal(TreeNode root) {
        
        // ITERATIVE
        LinkedList<Integer> result = new LinkedList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode p = root;
        while(!stack.isEmpty() || p != null) {
            if(p != null) {
                stack.push(p);
                result.addFirst(p.val);  // Reverse the process of preorder
                p = p.right;             // Reverse the process of preorder
            } else {
                TreeNode node = stack.pop();
                p = node.left;           // Reverse the process of preorder
            }
        }
        return result;
    }
    
    // RECURSIVE
//     public List<Integer> postorderTraversal(TreeNode root) {
//         List<Integer> postorder = new ArrayList<>();
//         dfs(root, postorder);
//         return postorder;
//     }
    
//     private void dfs(TreeNode node, List<Integer> postorder){
//         if(node == null){
//             return;
//         }
        
//         dfs(node.left, postorder);
//         dfs(node.right, postorder);
//         postorder.add(node.val);
//     }
}