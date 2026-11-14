class Solution {
    public static int find(int i,int [] arr,int target){
        if(i==arr.length){
            if(target==0) return 1;
            else return 0;
        }
        int add=find(i+1,arr,target+arr[i]);
        int sub=find(i+1,arr,target-arr[i]);
        return add+sub;
    }
    public int findTargetSumWays(int[] arr, int target) {
        int n=arr.length;
        int sum=0;

        for(int i=0;i<n;i++){
            sum+=arr[i];
        }

        int[][]dp=new int[n][2*sum];
        return find(0,arr,target);

    }
}