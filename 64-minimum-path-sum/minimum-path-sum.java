class Solution {
    public static int sol(int[][] arr,int i,int j,int[][]dp){
        int m=arr.length;
        int n=arr[0].length;

        if(i==m-1 && j==n-1) return arr[i][j];
        if(i>=m || j>=n) return Integer.MAX_VALUE;

        if(dp[i][j]!=-1) return dp[i][j];

        int right=sol(arr,i,j+1,dp);
        int down=sol(arr,i+1,j,dp);

        return dp[i][j]=arr[i][j]+Math.min(right,down);
    }
    public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;

        int[][]dp=new int[m][n];

        for(int[] row:dp){
            Arrays.fill(row,-1);
        }

        return sol(grid,0,0,dp);
    }
}