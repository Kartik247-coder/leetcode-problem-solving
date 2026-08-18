class Solution {
    public int maxSubArray(int[] arr) {
        int n=arr.length;
        int ans=Integer.MIN_VALUE;
        int best=0;
        for(int i=0;i<n;i++){
            best=Math.max(arr[i],best+arr[i]);
            ans=Math.max(best,ans);
        }
        return ans;
    }
}