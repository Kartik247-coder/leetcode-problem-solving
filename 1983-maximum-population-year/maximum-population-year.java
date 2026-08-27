class Solution {
    public int maximumPopulation(int[][] logs) {
        int[] years = new int[101];

        for (int[] log : logs) {
            for (int year = log[0]; year < log[1]; year++) {
                years[year - 1950]++;
            }
        }

        int max = 0;
        int ans = 1950;

        for (int i = 0; i < 101; i++) {
            if (years[i] > max) {
                max = years[i];
                ans = i + 1950;
            }
        }

        return ans;
    }
}