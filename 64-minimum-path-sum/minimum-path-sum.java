class Solution {
    public static int find (int[][] arr,int i,int j,int[][]dp){
        if(i>=arr.length || j>=arr[0].length) return Integer.MAX_VALUE;
        if(i==arr.length-1 && j==arr[0].length-1) return arr[arr.length-1][arr[0].length-1];
        if(dp[i][j]!=-1) return dp[i][j];
        return dp[i][j]=arr[i][j]+Math.min(find(arr,i,j+1,dp),find(arr,i+1,j,dp));
    }
    public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[][]dp=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                Arrays.fill(dp[i],-1);
            }
        }
        return find(grid,0,0,dp);
    }
}