class Solution {
    
    static int ans = 0;
    
    public int solution(int[] numbers, int target) {
        
        dfs(numbers, 0, 0, target);
        
        return ans;
    }
    
    static void dfs(int[] num, int idx, int res, int tar) {
        if(idx==num.length) {
            if(res==tar) ans++;
            return;
        }        
        dfs(num, idx+1, res-num[idx], tar);
        dfs(num, idx+1, res+num[idx], tar);
    }
}
