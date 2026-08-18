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
    public static TreeNode sol(int[] arr,int lo,int hi){
        if(lo>hi) return null;
        if(lo==hi){
         TreeNode root=new TreeNode(arr[lo]);
         return root;
        }
        int mid=lo+(hi-lo)/2;
        TreeNode root=new TreeNode(arr[mid]);
        root.left=sol(arr,lo,mid-1);
        root.right=sol(arr,mid+1,hi);
        return root;
    }
    public TreeNode sortedArrayToBST(int[] arr) {
       return sol(arr,0,arr.length-1);
    }
}