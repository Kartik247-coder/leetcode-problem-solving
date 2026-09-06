class Solution {
    public static void bfs(int i,boolean[] vis,int[][]arr){
      vis[i]=true;
      Queue<Integer> q=new LinkedList<>();
      q.add(i);
      while(!q.isEmpty()){
        int top=q.remove();
        for(int j=0;j<arr.length;j++){
            if(!vis[j] && arr[top][j]==1){
                q.add(j);
                vis[j]=true;
            }
        }
      }
    }
    public int findCircleNum(int[][] arr) {
      int n=arr.length;
      boolean[] vis=new boolean[n];
      int count=0;

      for(int i=0;i<n;i++){
        if(!vis[i]){
            bfs(i,vis,arr);
            count++;
        }
      }
      return count;
    }
}