class Solution {
    public static boolean isSquare(int n){
        int sqrt=(int)Math.sqrt(n);
        return n==sqrt*sqrt;
    }
    public static int sol(int n,int[] dp){
        if(dp[n]!=-1) return dp[n];
        if(isSquare(n)) return dp[n]=1;
       
        int min=Integer.MAX_VALUE;
        for(int i=1;i<=n/2;i++){
            int count=sol(i,dp)+sol(n-i,dp);
            min=Math.min(count,min);
        }

        return dp[n]=min;
    }
    public int numSquares(int n) {
        int[]dp=new int[n+1];
        Arrays.fill(dp,-1);
        return sol(n,dp);

    }
}