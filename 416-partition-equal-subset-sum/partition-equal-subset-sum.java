class Solution {
    public static boolean find(int[]arr,int i,int sum,int target,int[][]dp){
        if(sum==target) return true;
        if(i>=arr.length) return false;
        if(sum>target) return false;
        if(dp[i][sum]!=-1) return (dp[i][sum]==1);
        boolean ans=find(arr,i+1,sum,target,dp) || find(arr,i+1,sum+arr[i],target,dp);
        dp[i][sum]=(ans)?1:0;
        return ans;
    }
    public boolean canPartition(int[] arr) {
        int n=arr.length;
       
        int sum=0;
        for(int i=0;i<n;i++){
           sum+=arr[i];
        }
        if(sum%2!=0) return false;
        int total=sum/2;
        int[][] dp=new int[n][total+1];

        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return find(arr,0,0,sum/2,dp);
    }
}