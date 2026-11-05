class Solution {
    public int longestSubarray(int[] arr) {
        int n=arr.length;

        int i=0,j=0;

        int max=Integer.MIN_VALUE;

        int zero=0;

        while(j<n && i<n){
            int ele=arr[j];

            if(ele==0) zero++;

            while(i<n && zero>1){
                if(arr[i]==0) zero--;
                i++;
            }
            int leng=j-i+1;

            max=Math.max(max,leng-1);

            j++;
        }
        return max;
    }
}