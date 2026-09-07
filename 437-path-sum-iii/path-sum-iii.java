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
    public static int helper(TreeNode root,long target){
     if(root==null) return 0;
     int count=0;
     if(root.val==(long)target) count+=1;
     return count+helper(root.left,target-root.val)+helper(root.right,target-root.val);

    }
    public int pathSum(TreeNode root, int targetSum) {
        if(root==null) return 0;
        int count=0;
        count+=helper(root,(long)targetSum);
        return count+pathSum(root.left,targetSum)+pathSum(root.right,targetSum);
    }
}