class Solution {
    public static boolean isPossible(int[] arr,int mid,int n){
        int sum=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]%mid==0) sum+=arr[i]/mid;
            else sum+=arr[i]/mid+1;
        }
        if(sum<=n) return true;
        else return false;
    }
    public int minimizedMaximum(int n, int[] arr) {
        int length=arr.length;

        int max=Integer.MIN_VALUE;

        for(int i=0;i<length;i++){
            max=Math.max(max,arr[i]);
        }

        int lo=1,hi=max;
        int ans=max;

        while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            if(isPossible(arr,mid,n)){
                 ans=Math.min(ans,mid);
                 hi=mid-1;
            }
            else lo=mid+1;
        }
        return ans;
    }
}