class Solution {
    public static int sol(List<Integer> nums,int i,int target,int[][]dp){
        if(i==nums.size()){
            if(target==0) return 0;
            else return Integer.MIN_VALUE;
        }
        if(target==0) return 0;
        if(target<0) return Integer.MIN_VALUE;
        if(dp[i][target]!=-1) return dp[i][target];
        int skip=sol(nums,i+1,target,dp);
        
        int pick=sol(nums,i+1,target-nums.get(i),dp);
        if(pick!=Integer.MIN_VALUE) pick+=1;

        return dp[i][target]=Math.max(skip,pick);
    }
    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        if(nums.get(0)==target) return 1;
        int n=nums.size();
        int[][]dp=new int[n][target+1];
        for(int[]row:dp){
            Arrays.fill(row,-1);
        }
        int ans=sol(nums,0,target,dp);
        if(ans==Integer.MIN_VALUE) return -1;
        else return ans;
    }
}