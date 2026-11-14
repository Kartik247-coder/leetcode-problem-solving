class Solution {
    public static boolean isPossible(int[] arr,int mid,int days){
        int sum=1;
        int c=mid;
        int n=arr.length;
        int load=0;
        for(int i=0;i<n;i++){
            if(load+arr[i]<=c){
                load+=arr[i];
            }
            else{
                load=arr[i];
                sum++;
            }
        }
        if(sum<=days) return true;
        else return false;
    }
    public int shipWithinDays(int[] arr, int days) {
        int n=arr.length;

        int max=Integer.MIN_VALUE;
        int sum=0;
        
        for(int i=0;i<n;i++){
            max=Math.max(max,arr[i]);
            sum+=arr[i];
        }

        int lo=max,hi=sum;
        int ans=sum;

        while(lo<=hi){
            int mid=lo+(hi-lo)/2;

            if(isPossible(arr,mid,days)){
                  ans=mid;
                  hi=mid-1;
            }
            else lo=mid+1;
        }
        return ans;

    }
}