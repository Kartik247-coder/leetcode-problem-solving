class Solution {
    public int longestPalindrome(String[] words) {
        HashMap<String, Integer> mp = new HashMap<>();

        for (String word : words) {
            mp.put(word, mp.getOrDefault(word, 0) + 1);
        }

        boolean centerUsed = false;
        int result = 0;

        for (String word : words) {

            String rev = new StringBuilder(word).reverse().toString();

            if (!rev.equals(word)) {

                
                if (mp.getOrDefault(word, 0) > 0 &&
                    mp.getOrDefault(rev, 0) > 0) {

                    mp.put(word, mp.get(word) - 1);
                    mp.put(rev, mp.get(rev) - 1);

                    result += 4;
                }

            } else {

                if (mp.get(word) >= 2) {

                    mp.put(word, mp.get(word) - 2);
                    result += 4;

                } else if (mp.get(word) == 1 && !centerUsed) {

                    mp.put(word, mp.get(word) - 1);
                    result += 2;

                    centerUsed = true;
                }
            }
        }

        return result;
    }
}