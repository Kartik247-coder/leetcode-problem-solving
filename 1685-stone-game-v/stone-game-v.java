class Solution {

    int[][] dp;
    int[] prefix;

    public int solve(int lo, int hi) {
        if (lo == hi) {
            return 0;
        }

        if (dp[lo][hi] != -1) {
            return dp[lo][hi];
        }

        int ans = 0;

        for (int k = lo; k < hi; k++) {

            int leftSum = prefix[k + 1] - prefix[lo];
            int rightSum = prefix[hi + 1] - prefix[k + 1];

            if (leftSum < rightSum) {
                ans = Math.max(ans,
                        leftSum + solve(lo, k));

            } else if (leftSum > rightSum) {
                ans = Math.max(ans,
                        rightSum + solve(k + 1, hi));

            } else {
                ans = Math.max(ans,
                        Math.max(
                            leftSum + solve(lo, k),
                            rightSum + solve(k + 1, hi)
                        )
                );
            }
        }

        return dp[lo][hi] = ans;
    }

    public int stoneGameV(int[] stoneValue) {

        int n = stoneValue.length;

        dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        prefix = new int[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + stoneValue[i];
        }

        return solve(0, n - 1);
    }
}