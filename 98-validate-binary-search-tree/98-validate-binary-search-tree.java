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
    public boolean isValidBST(TreeNode root) {
        //if(root==null) return false;
        boolean ans = helper(Long.MIN_VALUE,Long.MAX_VALUE,root);
        return ans;
    }
    public static boolean helper(long min,long max,TreeNode root){
        if(root==null) return true;
        
        if(root.val<=min || root.val>=max) return false;
        
        return helper(min,root.val,root.left)&& helper(root.val,max,root.right);
        
    }
}