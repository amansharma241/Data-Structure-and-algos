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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return helper(postorder.length-1,0,postorder,0,inorder.length-1,inorder,map);
    }
    public TreeNode helper(int postart,int postend,int [] postorder,int instart,int inend,int [] inorder,HashMap<Integer,Integer> map){
        if(instart>inend || postart<postend) return null;
        TreeNode root = new TreeNode(postorder[postart]);
        int inIndex = map.get(root.val);
        int numsleft = inIndex-instart;
        int numsright = inend - inIndex;
        root.right = helper(postart-1,postart-numsright,postorder,inIndex+1,inend,inorder,map);
        root.left = helper(postart-numsright-1,postend,postorder,instart,inIndex-1,inorder,map);
        
        return root;
    }
}