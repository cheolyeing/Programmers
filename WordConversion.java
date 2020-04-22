import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
		int answer = 0;
		boolean[] visited = new boolean[words.length];
		
		Queue<String> q = new LinkedList<String>();
        q.add(begin);
        
        while(!q.isEmpty()) {
        	int s = q.size();
        	for(int i=0; i<s; i++) {
        		String tmp = q.poll();
        		if(tmp.equals(target)) {
        			return answer;
        		}
        		for(int j=0; j<words.length; j++) {
        			if(!visited[j] && change(tmp, words[j])) {
        				visited[j] = true;
        				q.add(words[j]);
        			}
        		}
        	}
        	answer++;
        }
		
        return 0;
    }
	
	static boolean change(String a, String b) {
		int diff = 0;
		for(int i=0; i<a.length(); i++) {
			if(a.charAt(i)!=b.charAt(i)) diff++;
		}
		return diff==1;
	}
}
