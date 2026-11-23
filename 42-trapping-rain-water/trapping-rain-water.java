class Solution {
    public static int[] findprev(int[]arr){
        int n=arr.length;
        int[] ans=new int[n];
        ans[0]=arr[0];

        for(int i=1;i<n;i++){
            ans[i]=Math.max(ans[i-1],arr[i]);
        }
        return ans;
    }
    public static int[] findnext(int[]arr){
        int n=arr.length;
        int[] ans=new int[n];
       
        ans[n-1]=arr[n-1];

        for(int i=n-2;i>=0;i--){
            ans[i]=Math.max(arr[i],ans[i+1]);
        }
        return ans;
    }
    public int trap(int[] arr) {
        int n=arr.length;

        int[]pge=findprev(arr);
        int[]nge=findnext(arr);

        int total=0;

        for(int i=0;i<n;i++){
            int left=pge[i];
            int right=nge[i];

            int temp=Math.min(left,right)-arr[i];

            if(temp>0) total+=temp;
        }
        return total;
    }
}