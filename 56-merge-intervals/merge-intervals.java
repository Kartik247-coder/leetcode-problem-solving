class Solution {
    public int[][] merge(int[][] arr) {
        int n=arr.length;
         
        Arrays.sort(arr,(a,b)->a[0]-b[0]);

        int start=arr[0][0];
        int end=arr[0][1];
        int[][] ans=new int[n][2];
        int k=0;

        for(int i=1;i<n;i++){
            if(arr[i][0]<=end){
                end=Math.max(arr[i][1],end);
                start=Math.min(arr[i][0],start);
            }
            else{
                ans[k][0]=start;
                ans[k][1]=end;
                start=arr[i][0];
                end=arr[i][1];
                k++;
            }
        }
        ans[k][0]=start;
        ans[k][1]=end;

        return Arrays.copyOf(ans,k+1);
    }
}