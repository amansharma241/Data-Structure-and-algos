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
    int count=0;
    public int goodNodes(TreeNode root) {
        helper(root,Integer.MIN_VALUE);
        return count;
    }
    public int helper(TreeNode root,int max){
        if(root==null) return 0;
        if(root.val>=max){
            max=root.val;
            count++;
        }
        int left = helper(root.left,max);
        int right = helper(root.right,max);
        
        return left + right;
    }
}