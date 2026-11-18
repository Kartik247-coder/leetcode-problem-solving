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
    public static List<List<Integer>> ans;
    public static void helper(TreeNode root,int targetSum,List<Integer> list){
        if(root==null) return;
        list.add(root.val);
        if(root.left==null && root.right==null){
            if(root.val==targetSum){
               ans.add(new ArrayList<>(list));
            }
            list.remove(list.size()-1);
            return;
        }
       
        helper(root.left,targetSum-root.val,list);
        helper(root.right,targetSum-root.val,list);
        list.remove(list.size()-1);

    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        ans=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        helper(root,targetSum,list);
        return ans;
    }
}