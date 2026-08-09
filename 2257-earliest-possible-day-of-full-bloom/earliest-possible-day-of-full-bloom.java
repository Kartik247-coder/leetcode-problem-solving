class Solution {
    public int earliestFullBloom(int[] plant, int[] time) {
        int n = plant.length;
        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++) {
            idx[i] = i;
        }
        Arrays.sort(idx, (a, b) -> time[b] - time[a]);
        int day = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            int j = idx[i];

            day += plant[j];
            max = Math.max(max, day + time[j]);
        }
        return max;
    }
}