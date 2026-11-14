class Solution {
    public static int find(int row,int col,int i,int j,int[][] dp){
        if(i>=row ||j>=col) return 0;
        if(i==row-1 ||j==col-1) return 1;
        if(dp[i][j]!=-1) return dp[i][j];
        int right=find(row,col,i,j+1,dp);
        int down=find(row,col,i+1,j,dp);
        return dp[i][j]=right+down;
    }
    public int uniquePaths(int m, int n) {
        int[][] dp=new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(dp[i],-1);
        }
        return find(m,n,0,0,dp);
    }
}