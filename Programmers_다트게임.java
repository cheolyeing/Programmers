public class Programmers_다트게임 {
	
	public static void main(String[] args) {
		solution("1D2S#10S");
	}
	
	static int solution(String dartResult) {
        int answer = 0;
        
        int idx = 0;
        int prevPoint = 0;
        
        while(true) {
        	
        	int start = idx;
        	int end = idx+2;
        	int point = 0;
        	
        	while(end<dartResult.length() && (48>(int)dartResult.charAt(end) || (int)dartResult.charAt(end)>57)) end++;
        	
        	String s = dartResult.substring(idx, end);
        	
        	if(s.charAt(s.length()-1)=='*') {
        		char c = s.charAt(s.length()-2);
        		int num = Integer.parseInt(s.substring(0, s.length()-2));
        		point = 2*num;
        		if(c=='D') point *= num;
        		if(c=='T') point *= num * num;
        		answer += point;
        		answer += prevPoint;
        	} else if(s.charAt(s.length()-1)=='#') {
        		char c = s.charAt(s.length()-2);
        		int num = Integer.parseInt(s.substring(0, s.length()-2));
        		point = -num;
        		if(c=='D') point *= num;
        		if(c=='T') point *= num * num;
        		answer += point;
        	} else {
        		char c = s.charAt(s.length()-1);
        		int num = Integer.parseInt(s.substring(0, s.length()-1));
        		point = num;
        		if(c=='D') point *= num;
        		if(c=='T') point *= num * num;
        		answer += point;
        	}
        	
        	prevPoint = point;
        	idx = end;
        	if(end==dartResult.length()) break;
        }
        
        return answer;
    }
}
