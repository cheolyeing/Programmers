import java.util.*;
class Solution {
    public boolean solution(int n, int[][] path, int[][] order) {
        boolean visit[] = new boolean[n];
        boolean reached[] = new boolean[n];
        int before[] = new int[n];
        int after[] = new int[n];
        Arrays.fill(before, -1);
        Arrays.fill(after, -1);

        for (int[] info : order) {
            int bef = info[0];
            int aft = info[1];
            before[bef] = aft;
            after[aft] = bef;
        }

        if(after[0]!=-1) return false;

        List[] connect = new List[n];
        for (int i = 0; i < n; i++) {
            connect[i] = new ArrayList<Integer>();
        }

        for (int[] info : path) {
            int a = info[0];
            int b = info[1];
            connect[a].add(b);
            connect[b].add(a);
        }

        Queue<Integer> q = new LinkedList<Integer>();

        q.add(0);
        visit[0] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int i = 0; i < connect[cur].size(); i++) {
                int p = (int) connect[cur].get(i);
                reached[p] = true;
                if (!visit[p]) {
                    if (after[p] == -1 || visit[after[p]]) {
                        q.add(p);
                        visit[p] = true;
                        if (before[p] != -1) {
                            after[before[p]] = -1;
                            if (reached[before[p]]) {
                                q.add(before[p]);
                                visit[before[p]] = true;
                            }
                        }
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (!visit[i]) return false;
        }
        return true;
    }
}
