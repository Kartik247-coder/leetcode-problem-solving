class Solution {

    public String lexPalindromicPermutation(String s, String target) {

        int n = s.length();

        // Count characters in s
        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        // Check whether a palindromic permutation exists
        int odd = 0;
        int middle = -1;

        for (int i = 0; i < 26; i++) {
            if (freq[i] % 2 == 1) {
                odd++;
                middle = i;
            }
        }

        if (odd > 1) {
            return "";
        }

        int halfLen = n / 2;

        // Frequencies available for the left half
        int[] halfFreq = new int[26];

        for (int i = 0; i < 26; i++) {
            halfFreq[i] = freq[i] / 2;
        }

        /*
         * First try to make the left half exactly equal
         * to target's first half.
         *
         * If possible, the resulting palindrome may already
         * be greater than target.
         */
        int[] remaining = halfFreq.clone();
        char[] equalHalf = new char[halfLen];

        boolean canEqual = true;

        for (int i = 0; i < halfLen; i++) {
            int c = target.charAt(i) - 'a';

            if (remaining[c] == 0) {
                canEqual = false;
                break;
            }

            equalHalf[i] = target.charAt(i);
            remaining[c]--;
        }

        if (canEqual) {
            String candidate = build(equalHalf, middle, n);

            if (candidate.compareTo(target) > 0) {
                return candidate;
            }
        }

        /*
         * Now find the smallest possible left half that is
         * lexicographically GREATER than target's first half.
         *
         * We try to keep the prefix equal to target for as long
         * as possible, then increase one position.
         *
         * Iterate from right to left because changing the
         * rightmost possible position gives the smallest result.
         */
        for (int change = halfLen - 1; change >= 0; change--) {

            remaining = halfFreq.clone();
            char[] left = new char[halfLen];

            boolean possible = true;

            // Match target before 'change'
            for (int i = 0; i < change; i++) {

                int c = target.charAt(i) - 'a';

                if (remaining[c] == 0) {
                    possible = false;
                    break;
                }

                left[i] = target.charAt(i);
                remaining[c]--;
            }

            if (!possible) {
                continue;
            }

            /*
             * At 'change', choose the smallest character
             * strictly greater than target[change].
             */
            int targetChar = target.charAt(change) - 'a';

            for (int c = targetChar + 1; c < 26; c++) {

                if (remaining[c] == 0) {
                    continue;
                }

                left[change] = (char) ('a' + c);
                remaining[c]--;

                /*
                 * Fill everything after 'change' with the
                 * smallest possible characters.
                 */
                int pos = change + 1;

                for (int x = 0; x < 26; x++) {
                    while (remaining[x] > 0) {
                        left[pos++] = (char) ('a' + x);
                        remaining[x]--;
                    }
                }

                String candidate = build(left, middle, n);

                if (candidate.compareTo(target) > 0) {
                    return candidate;
                }

                remaining[c]++;
            }
        }

        return "";
    }

    private String build(char[] left, int middle, int n) {

        StringBuilder sb = new StringBuilder(n);

        // Left half
        for (char c : left) {
            sb.append(c);
        }

        // Middle
        if (n % 2 == 1) {
            sb.append((char) ('a' + middle));
        }

        // Right half
        for (int i = left.length - 1; i >= 0; i--) {
            sb.append(left[i]);
        }

        return sb.toString();
    }
}