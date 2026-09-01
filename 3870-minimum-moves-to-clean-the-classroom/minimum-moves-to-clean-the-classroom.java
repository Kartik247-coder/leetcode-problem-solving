class Solution {
    public int minMoves(String[] classroom, int energy) {

        int m = classroom.length;
        int n = classroom[0].length();
        int[][] litterId = new int[m][n];

        int sr = 0, sc = 0;
        int litterCount = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                char ch = classroom[i].charAt(j);

                if (ch == 'S') {
                    sr = i;
                    sc = j;
                } 
                else if (ch == 'L') {
                    litterId[i][j] = litterCount++;
                }
            }
        }

        if (litterCount == 0) {
            return 0;
        }

        int totalMasks = 1 << litterCount;

        boolean[][][][] visited =
            new boolean[m][n][energy + 1][totalMasks];

        int startMask = (1 << litterCount) - 1;

        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{
            sr, sc, energy, startMask
        });

        visited[sr][sc][energy][startMask] = true;

        int moves = 0;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!queue.isEmpty()) {

            int size = queue.size();
            while (size-- > 0) {

                int[] curr = queue.poll();

                int r = curr[0];
                int c = curr[1];
                int currEnergy = curr[2];
                int mask = curr[3];

                if (mask == 0) {
                    return moves;
                }

                if (currEnergy == 0) {
                    continue;
                }

                for (int d = 0; d < 4; d++) {

                    int nr = r + dr[d];
                    int nc = c + dc[d];

                    if (nr < 0 || nr >= m ||
                        nc < 0 || nc >= n) {
                        continue;
                    }
                    if (classroom[nr].charAt(nc) == 'X') {
                        continue;
                    }
                    int newEnergy = currEnergy - 1;
                    if (classroom[nr].charAt(nc) == 'R') {
                        newEnergy = energy;
                    }

                    int newMask = mask;
                    if (classroom[nr].charAt(nc) == 'L') {

                        int id = litterId[nr][nc];
                        newMask &= ~(1 << id);
                    }

                 
                    if (!visited[nr][nc][newEnergy][newMask]) {

                        visited[nr][nc][newEnergy][newMask] = true;

                        queue.offer(new int[]{
                            nr, nc, newEnergy, newMask
                        });
                    }
                }
            }

            moves++;
        }

        return -1;
    }
}