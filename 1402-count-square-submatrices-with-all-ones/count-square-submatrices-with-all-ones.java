class Solution {
    public int countSquares(int[][] arr) {
        int m=arr.length;
        int n=arr[0].length;
        int count=0;

        int[][]dp=new int[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(arr[i][j]==0){
                     dp[i][j]=0;
                     continue;
                }
                else if(i==0 || j==0){
                    dp[i][j]=arr[i][j];
                    count++;
                }
                else{
                     dp[i][j]=arr[i][j]+Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]));
                     count+=dp[i][j];
                }
            }
        }
        return count;
    }
}