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
 // make arraylist of inorder traversal for root1 and similary for root2
 // merge two sorted list
class Solution {
    //problems
    public static List<Integer> merge(List<Integer> a,List<Integer> b,List<Integer> ans){
     int i=0,j=0,k=0;
     while(i<a.size() && j<b.size()){
        if(a.get(i)<=b.get(j)){
            ans.add(a.get(i));
            i++;
        }
        else{
            ans.add(b.get(j));
            j++;
        }
     }
     while(i<a.size()){
        ans.add(a.get(i));
            i++;
     }
     while(j<b.size()){
        ans.add(b.get(j));
        j++;
     }
     return ans;
    }
    public static List<Integer> inorder(TreeNode root){

        List<Integer> list=new ArrayList<>();

        TreeNode curr=root;
        while(curr!=null){
            if(curr.left!=null){
                TreeNode pred=curr.left;
                while(pred.right!=null && pred.right!=curr){
                    pred=pred.right;
                }
                if(pred.right==null){
                    pred.right=curr;
                    curr=curr.left;
                }
                if(pred.right==curr){
                 pred.right=null;
                 list.add(curr.val);
                 curr=curr.right;
                }
            }
            else{
                list.add(curr.val);
                curr=curr.right;
            }
        }
        return list;
        
    }
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list1=inorder(root1);
        List<Integer> list2=inorder(root2);
        List<Integer> ans=new ArrayList<>();
        merge(list1,list2,ans);
        return ans;
    }
}