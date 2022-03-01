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
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> res = helper(1,n);
        return res;
    }
    public List<TreeNode> helper(int st,int end){
        ArrayList<TreeNode> ans = new ArrayList<>();
        if(st>end){
            ans.add(null);
            return ans;
        }
        for(int i=st;i<=end;i++){
            List<TreeNode> left = helper(st,i-1);
            List<TreeNode> right = helper(i+1,end);
            
            for(TreeNode l:left){
                for(TreeNode r:right){
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    ans.add(root);
                }
            }
            
        }
        return ans;
    }
}