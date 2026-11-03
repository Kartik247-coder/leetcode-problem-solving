class Solution {
    public int pivotIndex(int[] nums) {
        int n=nums.length;
        int[] arr=new int[n];
        arr[0]=nums[0];
        for(int i=1;i<n;i++){
           arr[i]+=arr[i-1]+nums[i];
        }
        
        int left=0;
        int right=0;
        for(int i=0;i<n;i++){
            if(i==0) {
             right=arr[n-1]-arr[i];
             if(right==0) return i;
            }
            else if(i==n-1){
                left=arr[n-2];
                if(left==0) return i;
            }
            else{
                left=arr[i-1];
                right=arr[n-1]-arr[i];
                if(left==right) return i;
            }
          
        }
        return -1;
    }
}