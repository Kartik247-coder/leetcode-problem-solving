class Solution {
    public static int sol(int[] arr,int i,int target,int[][]dp){
        if(i==arr.length){
            if(target==0) return 0;
            else return Integer.MAX_VALUE;
        }
        if(dp[i][target]!=-1) return dp[i][target];
        int skip=sol(arr,i+1,target,dp);
        if(target-arr[i]<0) return skip;
        int pick=sol(arr,i,target-arr[i],dp);
        if(pick!=Integer.MAX_VALUE) pick+=1;
        return dp[i][target]=Math.min(skip,pick);
    }
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        if(n==1){
            if(amount==0) return 0;
        }
        int[][]dp=new int[n][amount+1];

        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
       
        int ans=sol(coins,0,amount,dp);
        if(ans==Integer.MAX_VALUE) return -1;
        else return ans;
        
    }
}