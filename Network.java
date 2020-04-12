import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        
    	int answer = 0;
    	boolean[] visited = new boolean[n];
    	
    	for(int i=0; i<n; i++) {
        	if(!visited[i]) { answer++;
        		Queue<Integer> q = new LinkedList<Integer>();
        		q.add(i); visited[i] = true;
                             
        		while(!q.isEmpty()) {
        			int s = q.size();
        			for(int j=0; j<q.size(); j++) {
        				int com = q.poll();
        				for(int k=0; k<n; k++) {
        					if(computers[com][k]==1 && !visited[k]) {
        						visited[k] = true;
        						q.add(k);
        					}
        				}
        			}
        		}
        	}
        }        
        return answer;
    }
}
