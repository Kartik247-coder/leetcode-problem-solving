class Solution {
    public static int find(int i,List<Integer> nums,int target,int[][]dp){
       if(target<0) return Integer.MIN_VALUE;
       if(i==nums.size()){
            if(target==0) return 0;
            else return Integer.MIN_VALUE;
       }
       if(dp[i][target]!=-1) return dp[i][target];
       int skip=find(i+1,nums,target,dp);
       int pick=find(i+1,nums,target-nums.get(i),dp);
       if(pick!=Integer.MIN_VALUE){
        pick+=1;
       }
       return dp[i][target]=Math.max(skip,pick);
      
    }
    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        int n=nums.size();
        
        int[][] dp=new int[n][target+1];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        
        int ans=find(0,nums,target,dp);

        if(ans==Integer.MIN_VALUE) return -1;
        else return ans;

    }
}