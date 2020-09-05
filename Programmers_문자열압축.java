class Solution {
    public int solution(String s) {
        int answer = s.length();
        for (int i = 1; i <= s.length() / 2; i++) {
            String temp = s.substring(0, i);
            String result = "";
            int count = 1;
            
            for (int j = i; j <= s.length(); j+=i) {
                if (j + i > s.length()) {
                    if (count == 1) {
                        result += temp;
                        result += s.substring(j, s.length());
                    } else {
                        result += count + "" + temp;
                        result += s.substring(j, s.length());
                    }
                    break;
                }

                if (temp.equals(s.substring(j, j + i))) {
                    count++;
                } else {
                    if (count == 1) {
                        result += temp;
                        temp = s.substring(j, i+j);
                    } else {
                        result += count + "" + temp;
                        temp = s.substring(j, i + j);
                        count = 1;
                    }
                }
            }
            answer = Math.min(answer, result.length());
        }

        return answer;
    }
}
