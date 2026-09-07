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
    public static TreeNode inorder(int[] arr,int lo,int hi){
        if(lo>hi) return null;
        if(lo==hi){
            TreeNode root=new TreeNode(arr[lo]);
            return root;
        }
        int mid=lo+(hi-lo)/2;
        TreeNode root=new TreeNode(arr[mid]);
        root.left=inorder(arr,lo,mid-1);
        root.right=inorder(arr,mid+1,hi);

        return root;
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        int n=nums.length;
        int lo=0,hi=n-1;
        return inorder(nums,lo,hi);
    }
}