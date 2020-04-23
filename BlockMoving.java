import java.util.*;
public class Programmers {
	static int n=0, m=0;
	static class Robot {
		public int x;
		public int y;
		public int garo;
		
		public Robot(int x, int y, int garo) {
			this.x = x;
			this.y = y;
			this.garo = garo;
		}
	}
	
	public static void main(String[] args) {
		int[][] board = {{0, 0, 0, 1, 1},{0, 0, 0, 1, 0},{0, 1, 0, 1, 1},{1, 1, 0, 0, 1},{0, 0, 0, 0, 0}};
		System.out.println(solution(board));
	}
	
	public static int solution(int[][] board) {
		n = board.length; m = board[0].length;
		boolean[][][] visited = new boolean[n][m][2];
		visited[0][0][1] = true;
		Queue<Robot> q = new LinkedList<Robot>();
		q.add(new Robot(0, 0, 1));
		int answer = 0;
		
		while(!q.isEmpty()) {
			int s = q.size();
			for(int i=0; i<s; i++) {
				Robot r = q.poll();
				//System.out.println(answer+"::: " + r.x+","+r.y+"["+r.garo+"]");
				if(r.garo==1) {
					if(r.x==n-1 && r.y==m-2) return answer;
					if(inRange(r.x, r.y+2) && !visited[r.x][r.y+1][1] && board[r.x][r.y+2]==0) {
						visited[r.x][r.y+1][1] = true;
						q.add(new Robot(r.x, r.y+1, 1));
					}
					if(inRange(r.x, r.y-1) && !visited[r.x][r.y-1][1] && board[r.x][r.y-1]==0) {
						visited[r.x][r.y-1][1] = true;
						q.add(new Robot(r.x, r.y-1, 1));
					}
					if(inRange(r.x-1, r.y) && inRange(r.x-1, r.y+1) && board[r.x-1][r.y]==0 && board[r.x-1][r.y+1]==0 ) {
						if(!visited[r.x-1][r.y][1]) {
							visited[r.x-1][r.y][1] = true;
							q.add(new Robot(r.x-1, r.y, 1));
						}
						if(!visited[r.x][r.y][0]) {
							visited[r.x][r.y][0] = true;
							q.add(new Robot(r.x-1, r.y, 0));
						}
						if(!visited[r.x][r.y+1][0]) {
							visited[r.x][r.y+1][0] = true;
							q.add(new Robot(r.x-1, r.y+1, 0));
						}
					}
					if(inRange(r.x+1, r.y) && inRange(r.x+1, r.y+1) && board[r.x+1][r.y]==0 && board[r.x+1][r.y+1]==0 ) {
						if(!visited[r.x+1][r.y][1]) {
							visited[r.x+1][r.y][1] = true;
							q.add(new Robot(r.x+1, r.y, 1));
						}
						if(!visited[r.x+1][r.y][0]) {
							visited[r.x+1][r.y][0] = true;
							q.add(new Robot(r.x, r.y, 0));
						}
						if(!visited[r.x+1][r.y+1][0]) {
							visited[r.x+1][r.y+1][0] = true;
							q.add(new Robot(r.x, r.y+1, 0));
						}
					}
				} else {
					if(r.x==n-2 && r.y==m-1) return answer;
					if(inRange(r.x-1, r.y) && !visited[r.x-1][r.y][0] && board[r.x-1][r.y]==0) {
						visited[r.x-1][r.y][0] = true;
						q.add(new Robot(r.x-1, r.y, 0));
					}
					if(inRange(r.x+2, r.y) && !visited[r.x+2][r.y][0] && board[r.x+2][r.y]==0) {
						visited[r.x+2][r.y][0] = true;
						q.add(new Robot(r.x+1, r.y, 0));
					}
					if(inRange(r.x, r.y+1) && inRange(r.x+1, r.y+1) && board[r.x][r.y+1]==0 && board[r.x+1][r.y+1]==0) {
						if(!visited[r.x][r.y+1][0]) {
							visited[r.x][r.y+1][0] = true;
							q.add(new Robot(r.x, r.y+1, 0));
						}
						if(!visited[r.x][r.y][1]) {
							visited[r.x][r.y][1] = true;
							q.add(new Robot(r.x, r.y, 1));
						}
						if(!visited[r.x+1][r.y][1]) {
							visited[r.x+1][r.y][1] = true;
							q.add(new Robot(r.x+1, r.y, 1));
						}
					}
					if(inRange(r.x, r.y-1) && inRange(r.x+1, r.y-1) && board[r.x][r.y-1]==0 && board[r.x+1][r.y-1]==0) {
						if(!visited[r.x][r.y-1][0]) {
							visited[r.x][r.y-1][0] = true;
							q.add(new Robot(r.x, r.y-1, 0));
						}
						if(!visited[r.x][r.y-1][1]) {
							visited[r.x][r.y-1][1] = true;
							q.add(new Robot(r.x, r.y-1, 1));
						}
						if(!visited[r.x+1][r.y-1][1]) {
							visited[r.x+1][r.y-1][1] = true;
							q.add(new Robot(r.x+1, r.y-1, 1));
						}
					}
				}
			} answer++;
		}
		
		return answer;
	}
	
	static boolean inRange(int x, int y) {
		return x>=0 && x<n && y>=0 && y<m;
	}
}
