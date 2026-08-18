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
    public static boolean ans;
    public static TreeNode prev;

    public static void inorder(TreeNode root){
        if(root==null) return;
        inorder(root.left);
      
        if(prev==null) prev=root;
        else if(root.val<=prev.val){
            ans=false;
            return;
        }
        else prev=root;

        inorder(root.right);

    }
    public boolean isValidBST(TreeNode root) {
        ans=true;
        prev=null;
        inorder(root);

        return ans;
    }
}