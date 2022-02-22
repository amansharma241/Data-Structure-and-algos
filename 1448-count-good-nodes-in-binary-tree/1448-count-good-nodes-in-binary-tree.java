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
    //int count=0;
    public int goodNodes(TreeNode root) {
      return FindGoodNodes(root,Integer.MIN_VALUE);
        //return count;
    }
    public int FindGoodNodes(TreeNode root,int max){
         int count = 0;
        
        if(root.val >= max){
            count++;
        }
        
        max = Math.max(max,root.val);
        
        if(root.left != null){
            count += FindGoodNodes(root.left, max);
        }
        
        if(root.right != null){
            
            count +=   FindGoodNodes(root.right, max);
        }  
        return count;
    }
}