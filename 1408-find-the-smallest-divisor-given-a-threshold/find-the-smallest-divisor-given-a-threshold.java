class Solution {
    public static boolean isLess(int[] arr,int mid,int t){
        int sum=0;

        for(int i=0;i<arr.length;i++){
            if(arr[i]%mid==0) sum+=arr[i]/mid;
            else sum+=arr[i]/mid+1;
        }
        if(sum<=t) return true;
        else return false;
    }
    public int smallestDivisor(int[] arr, int threshold) {
        int n=arr.length;

        int max=Integer.MIN_VALUE;

        for(int i=0;i<n;i++){
            max=Math.max(arr[i],max);
        }
        int hi=max,lo=1;
        int ans=Integer.MAX_VALUE;

        while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            
            if(isLess(arr,mid,threshold)){
                  ans=mid;
                  hi=mid-1;
            }
            else{
                lo=mid+1;
            }
        }
        return ans;
    }
}