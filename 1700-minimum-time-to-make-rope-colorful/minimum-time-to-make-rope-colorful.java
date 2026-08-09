class Solution {
    public int minCost(String str, int[] arr) {
        int n=str.length();
        if(n==1) return 0;
        int time=0;
        int j=1;
    
        
        while (j < n) {
            if (str.charAt(j - 1) == str.charAt(j)) {
                time += Math.min(arr[j - 1], arr[j]);
                arr[j] = Math.max(arr[j - 1], arr[j]);
            }
            j++;
        }

            
     
        return time;
    }
}