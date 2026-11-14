class Solution {
    public static int find(int[] arr,int i,int[]dp){
        if(i>=arr.length) return 0;
        if(dp[i]!=-1) return dp[i];
        int pick=arr[i]+find(arr,i+2,dp);
        int skip=find(arr,i+1,dp);
        return dp[i]=Math.max(pick,skip);
    }
    public int rob(int[] arr) {
        int n=arr.length;
        int[]dp=new int[n];
        Arrays.fill(dp,-1);
        return find(arr,0,dp);
    }
}