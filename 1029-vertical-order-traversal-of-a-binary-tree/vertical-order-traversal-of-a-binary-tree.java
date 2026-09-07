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
    public static TreeMap<Integer,TreeMap<Integer,List<Integer>>> map;

    public static void dfs(int row,int col,TreeNode root){
       if(root==null) return;

       if(!map.containsKey(col)){
        map.put(col,new TreeMap<>());
       }
       if(!map.get(col).containsKey(row)){
        map.get(col).put(row,new ArrayList<>());
       }
       map.get(col).get(row).add(root.val);

       dfs(row+1,col-1,root.left);
       dfs(row+1,col+1,root.right);
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        map=new TreeMap<>();
        List<List<Integer>> ans=new ArrayList<>();
        if(root==null) return ans;
        dfs(0,0,root);

        for(int set:map.keySet()){
            TreeMap<Integer,List<Integer>> temp=map.get(set);
            List<Integer> sub=new ArrayList<>();
            for(int key:temp.keySet()){
                List<Integer> list=temp.get(key);
                Collections.sort(list);
                sub.addAll(list);
            }
            ans.add(new ArrayList<>(sub));
        }
        return ans;
    }
}