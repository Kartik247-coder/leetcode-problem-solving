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
    public static List<Long> list;
    public static long ans;
    public static void sol(TreeNode root,int level,long idx){
        if(root==null) return;
        if(list.size()==level){
            list.add(idx);
        }
        ans=Math.max(ans,idx-list.get(level)+1);
        sol(root.left,level+1,2*idx);
        sol(root.right,level+1,2*idx+1);
    }
    public int widthOfBinaryTree(TreeNode root) {
        list=new ArrayList<>();
        ans=0;
        sol(root,0,0);
        return (int)ans;
    }
}