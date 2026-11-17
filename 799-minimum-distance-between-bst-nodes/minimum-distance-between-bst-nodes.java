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
    public static int diff;
    public static TreeNode prev;

    public static void inorder(TreeNode root){
        if(root==null) return;
        inorder(root.left);
        if(prev!=null){
            diff=Math.min(diff,Math.abs(root.val-prev.val));
            
        }
        prev=root;
        inorder(root.right);
    }
    public int minDiffInBST(TreeNode root) {
        prev=null;
        diff=Integer.MAX_VALUE;
        inorder(root);
        return diff;
    }
}