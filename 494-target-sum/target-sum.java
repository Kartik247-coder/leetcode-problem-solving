class Solution {
    public static int find(int i,int [] arr,int res,int target,int sum,int[][] dp){
        if(i>=arr.length){
            if(target==res) return 1;
            else return 0;
        }
        if(dp[i][res+sum]!=-1) return dp[i][res+sum];
        int add=find(i+1,arr,res+arr[i],target,sum,dp);
        int sub=find(i+1,arr,res-arr[i],target,sum,dp);
        return dp[i][res+sum]=add+sub;
    }
    public int findTargetSumWays(int[] arr, int target) {
        int n=arr.length;
        int sum=0;

        for(int i=0;i<n;i++){
            sum+=arr[i];
        }

        int[][]dp=new int[n][2*sum+1];

        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return find(0,arr,0,target,sum,dp);

    }
}