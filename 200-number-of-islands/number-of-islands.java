class Solution {
    public static int[][] arr={
        {1,0},
        {0,1},
        {-1,0},
        {0,-1}
    };

    public static void dfs(int i,int j,boolean[][] vis,char[][] grid){
        vis[i][j]=true;
        int m=grid.length;
        int n=grid[0].length;

        for(int t=0;t<4;t++){
            int left=i+arr[t][0];
            int right=j+arr[t][1];
            if(left<0 || left>=m || right<0 || right>=n) continue;
            if(!vis[left][right]&&grid[left][right]=='1')dfs(left,right,vis,grid);
        }
    }
    public int numIslands(char[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        boolean[][] vis=new boolean[m][n];

        int count=0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!vis[i][j] && grid[i][j]=='1'){
                    dfs(i,j,vis,grid);
                    count++;
                }
            }
        }
        return count;
    }
}