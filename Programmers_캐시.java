import java.util.*;

public class Programmers_캐시 {
	
	public static void main(String[] args) {
		
	}
	
	static int solution(int cacheSize, String[] cities) {
        if(cacheSize==0) return cities.length * 5;
		int answer = 0;
        
        Queue<String> q = new LinkedList<String>();

        for(int i=0; i<cities.length; i++) {
        	String city = cities[i].toLowerCase();
        	
        	if(q.contains(city)) {
        		q.remove(city);
        		q.add(city);
        		answer += 1;
        	} else {
        		if(q.size()>=cacheSize) {
        			q.poll();
        			q.add(city);
        		} else {
        			q.add(city);
        		}
        		answer += 5;
        	}
        	
        }
        return answer;
    }
}
