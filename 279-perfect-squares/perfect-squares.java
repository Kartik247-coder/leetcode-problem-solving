class Solution {
    public static boolean check(int n){
        int t=(int)Math.sqrt(n);
        return n==t*t;
    }
    public static int find(int n,int[] dp){
        if(check(n)) return 1;
        if(dp[n]!=-1) return dp[n];
        int min=Integer.MAX_VALUE;
        for(int i=1;i*i<=n;i++){
            int temp=find(i*i,dp)+find(n-i*i,dp);
            min=Math.min(temp,min);
        }
        return dp[n]=min;
    }
    public int numSquares(int n) {
        int[]dp=new int[n+1];
        Arrays.fill(dp,-1);
        return find(n,dp);
    }
}