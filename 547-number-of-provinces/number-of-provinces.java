class Solution {
    public static void dfs(int i,boolean[] vis,int[][]arr){
      vis[i]=true;
      for(int j=0;j<arr.length;j++){
        if(!vis[j] && arr[i][j]==1){
            dfs(j,vis,arr);
        }
      }
    }
    public int findCircleNum(int[][] arr) {
      int n=arr.length;
      boolean[] vis=new boolean[n];
      int count=0;

      for(int i=0;i<n;i++){
        if(!vis[i]){
            dfs(i,vis,arr);
            count++;
        }
      }
      return count;
    }
}