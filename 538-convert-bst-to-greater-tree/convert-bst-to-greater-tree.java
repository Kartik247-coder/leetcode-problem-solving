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
    public static int sum;
    public static TreeNode inorder(TreeNode root){
        if(root==null) return null;
        inorder(root.right);
        sum+=root.val;
        root.val=sum;
        inorder(root.left);
        return root;
    }
    public TreeNode convertBST(TreeNode root) {
        sum=0;
        return inorder(root);
    }
}