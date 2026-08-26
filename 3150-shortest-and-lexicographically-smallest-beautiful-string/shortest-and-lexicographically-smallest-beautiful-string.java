class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int n = s.length();

        int i = 0, j = 0;
        int temp = 0;
        int min = Integer.MAX_VALUE;
        String ans = "";

        while (i < n && s.charAt(i) != '1') i++;

       
        while (j < n && temp < k) {
            if (s.charAt(j) == '1') temp++;
            j++;
        }
        if (temp < k) return "";
        j--; 
        while (i < n && j < n) {

            int len = j - i + 1;

            if (len < min) {
                min = len;
                ans = s.substring(i, j + 1);
            } 
            else if (len == min) {
                String curr = s.substring(i, j + 1);

                if (ans.isEmpty() || curr.compareTo(ans) < 0) {
                    ans = curr;
                }
            }
            i++;
            while (i < n && s.charAt(i) != '1') i++;
            j++;
            while (j < n && s.charAt(j) != '1') j++;
        }

        return ans;
    }
}