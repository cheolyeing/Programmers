class Solution {
    static String[][] seq = {
            {"\\+", "-", "\\*"},
            {"\\+", "\\*", "-"},
            {"-", "\\+", "\\*"},
            {"-", "\\*", "\\+"},
            {"\\*", "\\+", "-"},
            {"\\*", "-", "\\+"}
    };

    static String[][] cont = {
            {"+", "-", "*"},
            {"+", "*", "-"},
            {"-", "+", "*"},
            {"-", "*", "+"},
            {"*", "+", "-"},
            {"*", "-", "+"}
    };
    public static long solution(String expression) {
        long answer = 0;

        for (int i = 0; i < 6; i++) {
            String s = expression;
            for (int j = 0; j < 3; j++) {
                if (!s.contains(cont[i][j])) continue;
                s = operate(s, seq[i][j]);
            }
            answer = Math.max(answer, Math.abs(Long.parseLong(s)));
        }
        return answer;
    }

    public static String operate(String s, String op) {
        String[] divided = s.split(op);
        String res = "";

        for (int i = 0; i < divided.length - 1; i++) {
            String[] s1 = divided[i].split("[+]|-|[*]");
            String[] s2 = divided[i + 1].split("[+]|-|[*]");

            long num1 = 0;
            long num2 = 0;
            if (s1[s1.length - 1].charAt(0) == '0' && s1[s1.length - 1].length() != 1) {
                num1 = -1 * Long.parseLong(s1[s1.length - 1].substring(1));
            } else {
                num1 = Long.parseLong(s1[s1.length - 1]);
            }

            if (s2[0].charAt(0) == '0' && s2[0].length() != 1) {
                num2 = -1 * Long.parseLong(s2[0].substring(1));
            } else {
                num2 = Long.parseLong(s2[0]);
            }

            int len1 = s1[s1.length - 1].length();
            int len2 = s2[0].length();
            long result = calculate(num1, num2, op);

            String add = "";
            if (result < 0) {
                add = "0" + Math.abs(result);
            } else add = result + "";

            divided[i] = divided[i].substring(0, divided[i].length() - len1);
            divided[i + 1] = add + divided[i + 1].substring(len2, divided[i + 1].length());
            res += divided[i];
        }
        return res + divided[divided.length - 1];
    }

    public static long calculate(long num1, long num2, String op) {
        if (op.equals("\\+")) {
            return num1 + num2;
        } else if (op.equals("\\*")) {
            return num1 * num2;
        } else {
            return num1 - num2;
        }
    }
}
