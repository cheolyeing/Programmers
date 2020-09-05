class Solution {
    public boolean solution(int[][] key, int[][] lock) {

        int m = key.length;
        int n = lock.length;
        int hole = hole(lock);

        for(int t=0; t<4; t++) {
            lock = turn(lock);
            for (int turn = 0; turn < 4; turn++) {
                key = turn(key);

                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        int cnt = 0;

                        loop:
                        for (int x = 0; x < m; x++) {
                            for (int y = 0; y < m; y++) {
                                if (x + i >= n || y + j >= n) continue;
                                if (lock[x + i][y + j] == key[x][y]) break loop;
                                if (lock[x + i][y + j] == 0 && key[x][y] == 1) cnt++;
                            }
                        }

                        if (cnt == hole) return true;
                    }
                }

            }
        }

        return false;
    }

    public int[][] turn(int[][] key) {
        int m = key.length;
        int[][] result = new int[m][m];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                result[i][j] = key[j][m - 1 - i];
            }
        }

        return result;
    }

    public int hole(int[][] lock) {
        int n = lock.length;
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (lock[i][j] == 0) cnt++;
            }
        }
        return cnt;
    }
}
