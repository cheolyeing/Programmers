class Solution {
    public static String solution(String p) {
        return action(p);
    }

    public static boolean isBalanced(String s) {
        int cntOpen = 0;
        int cntClose = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') cntOpen++;
            else cntClose++;
        }

        return cntOpen == cntClose;
    }

    public static boolean isCorrect(String s) {
        int cntOpen = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') cntOpen++;
            else {
                if (cntOpen == 0) return false;
                else cntOpen--;
            }
        }
        return true;
    }

    public static String action(String s) {
        if (s.equals("")) return s;

        String[] divided = divide(s);

        if (isCorrect(divided[0])) {
            return divided[0] + action(divided[1]);
        } else {
            return "(" + action(divided[1]) + ")" + action(change(divided[0]));
        }
    }

    public static String change(String s) {
        s = s.substring(1, s.length() - 1);

        String result = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') result += ')';
            else result += '(';
        }
        return result;
    }

    public static String[] divide(String s) {
        String[] result = new String[2];
        result[0] = "";
        result[1] = "";
        for (int i = 2; i <= s.length(); i++) {
            String temp = s.substring(0, i);
            if (isBalanced(temp)) {
                result[0] = temp;
                result[1] = s.substring(i, s.length());
                break;
            }
        }
        return result;
    }
}
