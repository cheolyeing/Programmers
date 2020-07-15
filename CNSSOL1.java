import java.util.*;

class Solution {
    public long solution(String expression) {
        long answer = Long.MIN_VALUE;

        ArrayList<String> list = new ArrayList<String>();

        int prev = 0;
        for(int i=1; i<expression.length(); i++) {
            char c = expression.charAt(i);
            if(c=='+' || c=='-' || c=='x') {
                list.add(expression.substring(prev, i));
                list.add(c+"");
                prev = i+1;
            }
        }
        list.add(expression.substring(prev, expression.length()));

        for(int i=0; i<list.size(); i+=2) {
            for(int j=i; j<=list.size(); j+=2) {
                answer = Math.max(answer, makeParenthesis(list, i, j));
            }
        }

        return answer;   
    }

    public long makeParenthesis(ArrayList<String> list, int left, int right) {

        ArrayList<String> exp = new ArrayList<String>();

        for(int i=left; i<=right; i++) {
            exp.add(list.get(i));
        }

        long tmpNum = calculator(exp);

        exp = new ArrayList<String>();
        for(String s : list) exp.add(s);
        for(int i=left; i<right; i++) {
            exp.remove(left);
        }
        exp.set(left, tmpNum+"");

        return calculator(exp);        
    }

    public long calculator(ArrayList<String> list) {

        ArrayList<String> exp = new ArrayList<String>();
        for(String s : list) exp.add(s);

        for(int i=0; i<exp.size(); i++) {
            String s = exp.get(i);
            if(s.equals("x")) {
                long num1 = Long.parseLong(exp.get(i-1));
                long num2 = Long.parseLong(exp.get(i+1));
                long res = num1 * num2;
                exp.set(i-1, "q");
                exp.set(i, "q");
                exp.set(i+1, res+"");
            }
        }

        for(int i=0; i<exp.size(); i++) {
            if(exp.get(i).equals("q")) {
                exp.remove(i--);
            }
        }

        long prev = Long.parseLong(exp.get(0));
        char op = 'x';
        for(int i=1; i<exp.size(); i++) {
            if(i%2==0) {
                long out = Long.parseLong(exp.get(i));
                if(op=='+') {
                    prev += out;
                } else {
                    prev -= out;
                }
            } else {
                op = exp.get(i).charAt(0);
            }
        }
        return prev;
    }
}
