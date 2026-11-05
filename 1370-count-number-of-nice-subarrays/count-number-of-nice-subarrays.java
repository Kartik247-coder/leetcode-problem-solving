class Solution {
    public int numberOfSubarrays(int[] arr, int k) {
        int n=arr.length;
        int a=0,j=0,i=0,b=0;
        int odd=0;
        int count=0;

        while(i<n && arr[i]%2==0) i++;
        while(j<n && odd<k){
            if(arr[j]%2!=0) odd++;
            j++;
        }
        if(odd<k) return 0;
        j--;
        b=j+1;

        while(b<n && arr[b]%2==0) b++;
        b--;

        while(b<n){
            count+=(i-a+1)*(b-j+1);
            a=i+1;
            i++;
            while(i<n && arr[i]%2==0) i++;

            j=b+1;
            b=j+1;

            while(b<n && arr[b]%2==0) b++;
            b--;
        }
        return count;
    }
}