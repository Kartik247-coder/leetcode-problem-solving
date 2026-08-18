class Solution {
    public int largestInteger(int[] arr, int k) {

        int n = arr.length;

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i <= n-k; i++) {

            HashSet<Integer> set = new HashSet<>();

            for(int j = i; j < i+k; j++) {
                set.add(arr[j]);
            }

            for(int x : set) {
                map.put(x, map.getOrDefault(x, 0) + 1);
            }
        }

        int num = -1;

        for(int ele : map.keySet()) {

            if(map.get(ele) == 1) {
                num = Math.max(num, ele);
            }
        }

        return num;
    }
}