import java.util.*;

class Solution {
    public static int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);
        int answer = 0;
        int left = 1, right = distance;

        while (left <= right) {
            int mid = (left + right) / 2;
            int cnt = removeNum(mid, rocks, distance, n);

            if (cnt <= n) {
                answer = Math.max(answer, mid);
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return answer;
    }

    static int removeNum(int d, int[] rocks, int distance, int n) {
        int prev = 0, cnt = 0;
        for (int i = 0; i < rocks.length; ++i) {
            if (rocks[i] - prev < d) cnt++;
            else prev = rocks[i];
        }

        if (distance - prev < d) cnt++;

        return cnt;
    }
}
