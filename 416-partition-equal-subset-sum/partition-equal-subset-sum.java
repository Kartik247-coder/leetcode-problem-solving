class Solution {
    public static boolean sol(int[]arr,int target,int i,int[][]dp){
        if(target==0) return true;
        if(i==arr.length){
            if(target==0) return true;
            else return false;
        }
        if(dp[i][target]!=-1) return  dp[i][target]==1;
        boolean ans=false;
        boolean skip=sol(arr,target,i+1,dp);
        if(target-arr[i]<0) return ans=skip;
        else{
             boolean pick=sol(arr,target-arr[i],i+1,dp);
             ans=pick||skip;
        }
       
        dp[i][target]=(ans)?1:0;
        return ans;
    }
    public boolean canPartition(int[] arr) {
        int n=arr.length;
        int sum=0;

        for(int i=0;i<n;i++){
            sum+=arr[i];
        }
        int target=sum/2;
        int[][] dp=new int[n][target+1];

        for(int[] row:dp){
            Arrays.fill(row,-1);
        }

        if(sum%2!=0) return false;

        return sol(arr,sum/2,0,dp);
    }
}