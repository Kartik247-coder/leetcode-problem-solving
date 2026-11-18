
class Solution {
    public int[] sortedSquares(int[] arr) {
        int n = arr.length;

        int idx = 0;
        while(idx < n && arr[idx] < 0) idx++;

        int i = idx - 1;
        int j = idx;

        for(int t = 0; t < n; t++) {
            arr[t] = arr[t] * arr[t];
        }

        int[] ans = new int[n];
        int k = 0;

        while(i >= 0 && j < n) {
            if(arr[i] > arr[j]) {
                ans[k++] = arr[j++];
            } else {
                ans[k++] = arr[i--];
            }
        }

        while(i >= 0) ans[k++] = arr[i--];
        while(j < n) ans[k++] = arr[j++];

        return ans;
    }
}

