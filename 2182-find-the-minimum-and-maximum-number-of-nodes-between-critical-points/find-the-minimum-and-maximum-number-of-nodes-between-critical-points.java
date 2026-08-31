class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {

        int first = -1;       // first critical point
        int prev = -1;        // previous critical point

        int minDist = Integer.MAX_VALUE;
        int maxDist = -1;

        int index = 1;

        ListNode left = head;
        ListNode curr = head.next;

        while (curr.next != null) {

            // Check if curr is a critical point
            boolean critical =
                (curr.val > left.val && curr.val > curr.next.val) ||
                (curr.val < left.val && curr.val < curr.next.val);

            if (critical) {

                // First critical point
                if (first == -1) {
                    first = index;
                }

                // From second critical point onwards
                if (prev != -1) {
                    minDist = Math.min(minDist, index - prev);
                    maxDist = Math.max(maxDist, index - first);
                }

                prev = index;
            }

            left = curr;
            curr = curr.next;
            index++;
        }

        // Fewer than 2 critical points
        if (minDist == Integer.MAX_VALUE) {
            return new int[]{-1, -1};
        }

        return new int[]{minDist, maxDist};
    }
}