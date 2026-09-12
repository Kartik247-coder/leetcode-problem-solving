import java.util.*;

class Solution {
    public int[] maximumWeight(List<List<Integer>> intervals) {
        int n = intervals.size();

 
        int[][] arr = new int[n][4];

        for (int i = 0; i < n; i++) {
            arr[i][0] = intervals.get(i).get(0);
            arr[i][1] = intervals.get(i).get(1);
            arr[i][2] = intervals.get(i).get(2);
            arr[i][3] = i;
        }

      
        Arrays.sort(arr, (a, b) -> {
            if (a[1] != b[1]) return Integer.compare(a[1], b[1]);
            return Integer.compare(a[3], b[3]);
        });

        // dp[i][k] = best selection using first i intervals and k intervals
        long[][] dp = new long[n + 1][5];

        // Store selected indices
        List<Integer>[][] chosen = new ArrayList[n + 1][5];

        for (int i = 0; i <= n; i++) {
            for (int k = 0; k <= 4; k++) {
                chosen[i][k] = new ArrayList<>();
            }
        }

        for (int i = 1; i <= n; i++) {
      
            for (int k = 0; k <= 4; k++) {
                dp[i][k] = dp[i - 1][k];
                chosen[i][k] = new ArrayList<>(chosen[i - 1][k]);
            }

            
            int prev = binarySearch(arr, i - 1);

            for (int k = 1; k <= 4; k++) {
                long value = dp[prev + 1][k - 1] + arr[i - 1][2];

                List<Integer> candidate =
                    new ArrayList<>(chosen[prev + 1][k - 1]);

                candidate.add(arr[i - 1][3]);

                if (value > dp[i][k] ||
                    (value == dp[i][k] && isBetter(candidate, chosen[i][k]))) {
                    dp[i][k] = value;
                    chosen[i][k] = candidate;
                }
            }
        }

        List<Integer> ans = chosen[n][4];

        Collections.sort(ans);

        int[] result = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            result[i] = ans.get(i);
        }

        return result;
    }


    private int binarySearch(int[][] arr, int index) {
        int start = arr[index][0];

        int lo = 0, hi = index - 1;
        int ans = -1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (arr[mid][1] < start) {
                ans = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return ans;
    }

    // Lexicographically smaller index list
    private boolean isBetter(List<Integer> a, List<Integer> b) {
        Collections.sort(a);
        Collections.sort(b);

        for (int i = 0; i < Math.min(a.size(), b.size()); i++) {
            if (!a.get(i).equals(b.get(i))) {
                return a.get(i) < b.get(i);
            }
        }

        return a.size() < b.size();
    }
}