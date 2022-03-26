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
    int totalSum = 0;
    public int sumNumbers(TreeNode root) {
        dfs(root, 0);
        return totalSum;
    }
    
    public void dfs(TreeNode node, int prefix){
        if(node == null)
            totalSum+=prefix;
        else{
            int cur = prefix*10+node.val;
            if(node.left!=null){
               dfs(node.left, cur); 
            }
            if(node.right!=null){
               dfs(node.right, cur); 
            }
            if(node.left == node.right && node.left == null){
                totalSum+=cur;
            }
        }
    }
}