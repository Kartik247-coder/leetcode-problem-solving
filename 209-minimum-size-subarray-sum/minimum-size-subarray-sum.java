class Solution {
    public int minSubArrayLen(int target, int[] arr) {
        int n=arr.length;
        int i=0,j=0;
        int sum=0;
        int min=Integer.MAX_VALUE;
        while(j<n && sum<target){
            sum+=arr[j];
            j++;
        }
        j--;

        while(i<n && j<n){
            if(sum>=target){
                min=Math.min(j-i+1,min);
            }
            sum-=arr[i];
            i++;
            j++;
            while(j<n && sum<target){
                sum+=arr[j];
                j++;
            }
            j--;

        }
        if(min==Integer.MAX_VALUE) return 0;
        else return min;
    }
}