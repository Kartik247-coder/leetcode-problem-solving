class Solution {
    public boolean sumGame(String num) {
        int n = num.length() / 2;

        int leftSum = 0;
        int rightSum = 0;
        int leftQ = 0;
        int rightQ = 0;

        for (int i = 0; i < n; i++) {
            if (num.charAt(i) == '?')
                leftQ++;
            else
                leftSum += num.charAt(i) - '0';
        }

        for (int i = n; i < num.length(); i++) {
            if (num.charAt(i) == '?')
                rightQ++;
            else
                rightSum += num.charAt(i) - '0';
        }

        int diff = leftSum - rightSum;
        int qDiff = leftQ - rightQ;

        if ((leftQ + rightQ) % 2 == 1)
            return true;

        // Bob can balance only if the existing difference
        // can be exactly compensated.
        return diff * 2 != -9 * qDiff;
    }
}