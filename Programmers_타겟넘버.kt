class Solution {
    
    var answer : Int = 0
    
    fun solution(numbers: IntArray, target: Int): Int {
        dfs(numbers, 0, 0, target)
        return answer
    }
    
    fun dfs(num: IntArray, idx: Int, res: Int, tar: Int) {
        if(idx==num.size) {
            if(res==tar) answer++
            return
        }
        dfs(num, idx+1, res-num[idx], tar)
        dfs(num, idx+1, res+num[idx], tar)
    }
}
