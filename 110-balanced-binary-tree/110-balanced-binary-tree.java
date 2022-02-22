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
    public boolean isBalanced(TreeNode root) {
        // wrong code is code ki wajah se tum sirf root se left height aur right height dekh rhe ho, question mein likha hai har node pe ye property match honi chahiye....
//         if(root==null) return true;
//         int left = height(root.left);
//         int right = height(root.right);
        
//         return Math.abs(left-right)<=1;
        return height(root)!=-1;
    }
    public int height(TreeNode root){
        if(root==null) return 0;
        
        int left = height(root.left);
        int right = height(root.right);
        if(left==-1 || right==-1 || Math.abs(left-right)>1) return -1;
        return Math.max(left,right) + 1;
    }
}