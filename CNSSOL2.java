import java.util.*;

class Solution{
    static int r=0, c=0;
    static int[][] d = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    static class Point {
        public int x, y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int solution(int[][] maps){
        int answer = 0;
        r = maps.length;
        c = maps[0].length;
        boolean visited[][] = new boolean[r][c];

        int adj[] = new int[2500];
        int num = 1;
        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                if(maps[i][j]==1 && !visited[i][j]) {
                    num++;
                    Queue<Point> q = new LinkedList<Point>();
                    q.add(new Point(i, j));
                    visited[i][j] = true;
                    maps[i][j] = num;

                    while(!q.isEmpty()) {
                        Point p = q.poll();
                        for(int k=0; k<4; k++) {
                            Point np = new Point(p.x+d[k][0], p.y+d[k][1]);
                            if(!inRange(np)) adj[num]++;
                            else if(maps[np.x][np.y]==1) {
                                visited[np.x][np.y] = true;
                                maps[np.x][np.y] = num;
                                q.add(np);
                            } else if(maps[np.x][np.y]==0) {
                                adj[num]++;
                            }
                        }
                    }
                    answer = Math.max(answer, adj[num]);
                }
            }
        }

        return answer;
    }

    public boolean inRange(Point p) {
        return p.x>=0 && p.y>=0 && p.x<r && p.y<c;
    }

}
