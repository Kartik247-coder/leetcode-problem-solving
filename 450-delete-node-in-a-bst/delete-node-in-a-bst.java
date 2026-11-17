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
    public static TreeNode find(TreeNode root,int key){
        if(root==null) return null;
        if(root.val>key){
            root.left=find(root.left,key);
        }
        else if(root.val<key){
            root.right=find(root.right,key);
        }
        else{
            if(root.left==null && root.right==null){
                return null;
            }
            else if(root.left==null){
                return root.right;
            }
            else if(root.right==null){
                return root.left;
            }
            else{
                TreeNode is=inOrderSuccessor(root.right);
                root.val=is.val;
                root.right=find(root.right,is.val);
            }
        }
        return root;
    }
    public static TreeNode inOrderSuccessor(TreeNode root){
        while(root.left!=null){
            root=root.left;
        }
        return root;
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        return find(root,key);
    }
}