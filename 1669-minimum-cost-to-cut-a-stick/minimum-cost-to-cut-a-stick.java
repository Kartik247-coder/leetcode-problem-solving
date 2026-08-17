class Solution {
    public static int sol(int i,int j,int[] arr,int[][]dp){
        if(i>j) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int min=Integer.MAX_VALUE;
        for(int k=i;k<=j;k++){
            int cost=arr[j+1]-arr[i-1];
            int total=sol(i,k-1,arr,dp)+sol(k+1,j,arr,dp)+cost;
            min=Math.min(min,total);
        }
        return dp[i][j]=min;
    }
    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        int m=cuts.length+2;
       

        int[] arr=new int[m];
        int[][] dp=new int[m][m];
        for(int i=1;i<=cuts.length;i++){
            arr[i]=cuts[i-1];
        }
        arr[0]=0;
        arr[m-1]=n;


        for(int i=0;i<m;i++){
            for(int j=0;j<m;j++){
                dp[i][j]=-1;
            }
        }

        return sol(1,m-2,arr,dp);

    }
}