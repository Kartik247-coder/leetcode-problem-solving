class Solution {
    public int minimumMountainRemovals(int[] arr) {
        int n=arr.length;
        int[] dp1=new int[n];
        int[] dp2=new int[n];

        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(arr[i]>arr[j]){
                    dp1[i]=Math.max(dp1[i],dp1[j]);
                }
            }
            dp1[i]++;
        }

        for(int i=n-1;i>=0;i--){
            for(int j=n-1;j>i;j--){
                if(arr[i]>arr[j]){
                    dp2[i]=Math.max(dp2[i],dp2[j]);
                }
            }
            dp2[i]++;
        }

        int max=Integer.MIN_VALUE;

        for(int i=0;i<n;i++){
            if(dp1[i]>1 && dp2[i]>1){
                int val=dp1[i]+dp2[i]-1;
                 max=Math.max(max,val);
            }    
        }
        if(max<3) return 0;
        return n-max;
    }
}