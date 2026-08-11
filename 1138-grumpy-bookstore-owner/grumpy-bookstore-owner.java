class Solution {
    public int maxSatisfied(int[] cust, int[] arr, int k) {
        int n = cust.length;

        int base = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                base += cust[i];
            }
        }
        int sum = 0;

        for (int i = 0; i < k; i++) {
            if (arr[i] == 1) {
                sum += cust[i];
            }
        }

        int max = sum;

        int i = 0;
        int j = k;

        while (j < n) {

            if (arr[i] == 1) {
                sum -= cust[i];
            }

            if (arr[j] == 1) {
                sum += cust[j];
            }

            i++;
            j++;

            max = Math.max(max, sum);
        }

        return base + max;
    }
}