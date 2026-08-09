class Solution {
    //kartik
    public static int sol(int[] arr,int i,int m,int[] suff,int[][]dp){

        int n=arr.length;
        if(i>=n) return 0;
        if(dp[i][m]!=-1) return dp[i][m];
        if(2*m>=n-i) return suff[i];
        int max=0;
        for(int x=1;x<=2*m;x++){
            int opp=sol(arr,i+x,Math.max(x,m),suff,dp);
            max=Math.max(max,suff[i]-opp);
        }
        return dp[i][m]=max;
    }
    public int stoneGameII(int[] arr) {
        int n=arr.length;
        int[][] dp=new int[n][n+1];
        for (int[] row : dp)
            Arrays.fill(row, -1);

        int[] suff=new int[n];
        suff[n-1]=arr[n-1];

        for(int i=n-2;i>=0;i--){
            suff[i]=suff[i+1]+arr[i];
        }
        return sol(arr,0,1,suff,dp);
    }
}