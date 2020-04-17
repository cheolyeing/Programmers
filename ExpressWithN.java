import java.util.*;

class Solution {
    static int answer = -1;
    public int solution(int N, int number) {
        
        dfs(N, number, 0,0);
        return answer;
    }
    
    static void dfs(int N, int number, int cnt, int prev) {
        int tmp = N;
        
        if(cnt>8) {
            return;
        }
        if(number==prev) {
            if(answer==-1 || answer>cnt)
            answer = cnt; return;
        }
        for(int i=0; i<8-cnt; i++) {
            dfs(N, number, cnt+i+1, prev+tmp);
            dfs(N, number, cnt+i+1, prev-tmp);
            dfs(N, number, cnt+i+1, prev*tmp);
            dfs(N, number, cnt+i+1, prev/tmp);
            tmp = nextNum(tmp, N);
        }
    }
    
    static int nextNum(int value, int N) {
        return value*10 + N;
    }
}
