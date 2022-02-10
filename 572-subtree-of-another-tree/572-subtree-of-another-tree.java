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
    public boolean isSubtree(TreeNode root, TreeNode sub) {
        if(root==null) return false;
        return isSubtree(root.left,sub) || isSubtree(root.right,sub) || same(root,sub);
    }
    public boolean same(TreeNode root,TreeNode sub){
        if(root==null && sub==null) return true;
        if(root==null || sub==null) return false;
        if(root.val!=sub.val) return false;
        
        return same(root.left,sub.left) && same(root.right,sub.right);
    }
}