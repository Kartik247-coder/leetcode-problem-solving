class Solution {
    public static boolean find(int i,int[]arr,int total,int[][]dp){
        if(i>=arr.length){
            if(total==0) return true;
            else return false;
        }
        if(dp[i][total]!=-1) return dp[i][total]==1;
        boolean skip=find(i+1,arr,total,dp);
        if(total-arr[i]<0) return skip;
        boolean pick=find(i+1,arr,total-arr[i],dp);
        boolean ans= skip|| pick;
        dp[i][total]=ans?1:0;
        return ans;
    }
    public boolean canPartition(int[] arr) {
        int n=arr.length;
        int sum=0;

        for(int i=0;i<n;i++){
            sum+=arr[i];
        }

        if(sum%2!=0)return false;

        int total=sum/2;

        int[][]dp=new int[n][total+1];

        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }

        return find(0,arr,total,dp);
    }
}