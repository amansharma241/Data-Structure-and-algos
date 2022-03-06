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
    public int minCameraCover(TreeNode root) {
        camera=0;
        int ans = traversal(root);
        if(ans==0){
            camera++;
        }
        return camera;
        
    }
    int camera;
    public int traversal(TreeNode node){
      if(node==null){
          return 2;
      }
      
      int left= traversal(node.left);
      int right=traversal(node.right);
        
        if(left==0 || right==0){
            camera++;
            return 1;
        }
        if(left==1 || right==1){
            return 2;
        }
        return 0;
    }
}