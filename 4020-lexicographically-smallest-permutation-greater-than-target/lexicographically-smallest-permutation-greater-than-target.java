class Solution {
    public String lexGreaterPermutation(String s, String target) {

        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < target.length(); i++) {

            int curr = target.charAt(i) - 'a';

            // Try to keep the prefix equal to target
            if (freq[curr] > 0) {

                freq[curr]--;
                ans.append(target.charAt(i));

            } else {

                // Cannot match target[i].
                // Find smallest character greater than target[i].
                int greater = findGreater(freq, curr);

                if (greater != -1) {
                    ans.append((char) ('a' + greater));
                    freq[greater]--;

                    appendRemaining(ans, freq);
                    return ans.toString();
                }

                // Need to backtrack
                while (ans.length() > 0) {

                    int pos = ans.length() - 1;

                    char removed = ans.charAt(pos);
                    ans.deleteCharAt(pos);

                    freq[removed - 'a']++;

                    int required = target.charAt(pos) - 'a';

                    greater = findGreater(freq, required);

                    if (greater != -1) {

                        ans.append((char) ('a' + greater));
                        freq[greater]--;

                        appendRemaining(ans, freq);

                        return ans.toString();
                    }
                }

                return "";
            }
        }

        // We made exactly target.
        // Therefore we need to backtrack to make it greater.
        while (ans.length() > 0) {

            int pos = ans.length() - 1;

            char removed = ans.charAt(pos);
            ans.deleteCharAt(pos);

            freq[removed - 'a']++;

            int required = target.charAt(pos) - 'a';

            int greater = findGreater(freq, required);

            if (greater != -1) {

                ans.append((char) ('a' + greater));
                freq[greater]--;

                appendRemaining(ans, freq);

                return ans.toString();
            }
        }

        return "";
    }

    private int findGreater(int[] freq, int c) {

        for (int i = c + 1; i < 26; i++) {
            if (freq[i] > 0) {
                return i;
            }
        }

        return -1;
    }

    private void appendRemaining(StringBuilder ans, int[] freq) {

        for (int i = 0; i < 26; i++) {

            while (freq[i] > 0) {
                ans.append((char) ('a' + i));
                freq[i]--;
            }
        }
    }
}