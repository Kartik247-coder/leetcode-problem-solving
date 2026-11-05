class Solution {
    public int longestOnes(int[] arr, int k) {
        int n=arr.length;

        int zero=0;
        int i=0,j=0;
        int max=Integer.MIN_VALUE;

        while(i<n && j<n){
            int ele=arr[j];

            if(ele==0) zero++;

            while(i<n && zero>k){
                if(arr[i]==0) zero--;
                i++;
            }

            int leng=j-i+1;
            max=Math.max(max,leng);
            j++;
        }
        return max;
    }
}