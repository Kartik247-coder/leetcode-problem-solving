class Solution {
    public boolean winnerSquareGame(int n) {
        if(n==1) return true;
        if(n==2) return false;
        boolean[] dp=new boolean[n+1];
        dp[1]=true;
        dp[2]=false;
        for(int i=1;i<=n;i++){
            for(int j=1;j*j<=i;j++){
                if(!dp[i-j*j]){
                    dp[i]=true;
                    break;
                }
            }
        }
        return dp[n];
    }
}