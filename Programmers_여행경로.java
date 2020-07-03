class Solution {
    static String[][] info;
	static boolean[] visited;
	static String ans = "";
    public String[] solution(String[][] tickets) {
		info = tickets;
		visited = new boolean[tickets.length];
		String[] start = {"", "ICN"};
		backTracking(start, 0, "");
		return ("ICN"+ans).split(",");
    }
	
	static void backTracking(String[] s, int n, String tot) {
		if(n==info.length) {
			if(ans.length()<1) ans = tot;
			else ans = compare(ans, tot);
			return;
		}
		for(int i=0; i<info.length; i++) {
			if(visited[i]) continue;
			if(info[i][0].equals(s[1])) {
				visited[i] = true;
				backTracking(info[i], n+1, tot+","+info[i][1]);
				visited[i] = false;
			}
		}
	}
	
	static String compare(String a1, String a2) {
		for(int i=0; i<a1.length(); i++) {
			if(a1.charAt(i)!=a2.charAt(i)) {
				if(a1.charAt(i)>a2.charAt(i)) return a2;
				else return a1;
			}
		}
		return a1;
	}
}
