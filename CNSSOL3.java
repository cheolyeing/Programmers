import java.util.*;

class Solution{
    static int r=0, c=0;
    static int[][] d = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    static class Point implements Comparable<Point>{
        public int x, y, val;
        public Point(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }

        @Override
        public int compareTo(Point p) {
            return this.val - p.val;
        }
    }

    public int[][] solution(int[][] city){
        r = city.length;
        c = city[0].length;
        int[][] answer = new int[r][c];

        PriorityQueue<Point> pq = new PriorityQueue<Point>();

        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                if(city[i][j]==0) pq.add(new Point(i, j, 0));
                else answer[i][j] = Integer.MAX_VALUE;
            }
        }

        while(!pq.isEmpty()) {
            Point p = pq.poll();
            for(int i=0; i<4; i++) {
                Point np = new Point(p.x+d[i][0], p.y+d[i][1], p.val+1);
                if(inRange(np)) {
                    if(answer[np.x][np.y]>np.val) {
                        answer[np.x][np.y] = np.val;
                        pq.add(np);
                    }
                }
            }
        }
        return answer;
    }

    public boolean inRange(Point p) {
        return p.x>=0 && p.y>=0 && p.x<r && p.y<c;
    }
}
