class Solution {
    public int numSubarrayProductLessThanK(int[] arr, int k) {
        if (k <= 1) return 0;

        int n = arr.length;
        int i = 0, j = 0, prod = 1, count = 0;

        // initial window creation (your style)
        while (j < n) {
            prod *= arr[j];

            while (prod >= k && i <= j) {
                prod /= arr[i];
                i++;
            }

            // key part: (j - i + 1) subarrays end at j
            count += (j - i + 1);
            j++;
        }

        return count;
    }
}