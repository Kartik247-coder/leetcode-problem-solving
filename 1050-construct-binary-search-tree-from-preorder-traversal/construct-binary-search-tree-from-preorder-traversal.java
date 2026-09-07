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
    public static TreeNode inorder(int[] pre,int lo,int hi){
        if(lo>hi) return null;
        TreeNode root=new TreeNode(pre[lo]);
        if(lo==hi){
            return root;
        }
        int idx=lo+1;
        while(idx<pre.length && pre[idx]<=pre[lo]){
            idx++;
        }
        idx--;
        root.left=inorder(pre,lo+1,idx);
        root.right=inorder(pre,idx+1,hi);
        return root;
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        return inorder(preorder,0,preorder.length-1);
    }
}