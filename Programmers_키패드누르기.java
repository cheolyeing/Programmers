class Solution {
    static Point left = new Point(1, 4);
    static Point right = new Point(3, 4);

    static class Point {
        public int x;
        public int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public String solution(int[] numbers, String hand) {
        String answer = "";

        for (int num : numbers) {
            int x = 0, y = 0;
            if (num == 0) {
                x = 2;
                y = 4;
            } else {
                x = num % 3 == 0 ? 3 : num % 3;
                y = (num + 2) / 3;
            }

            Point p = new Point(x, y);

            if (num % 3 == 0 && num!=0) {
                answer += "R";
                right = p;
            } else if (num % 3 == 1) {
                answer += "L";
                left = p;
            } else {
                int distLeft = dist(p, true);
                int distRight = dist(p, false);

                if (distLeft == distRight) {
                    if (hand.equals("left")) {
                        answer += "L";
                        left = p;
                    } else {
                        answer += "R";
                        right = p;
                    }
                } else if (distLeft > distRight) {
                    answer += "R";
                    right = p;
                } else {
                    answer += "L";
                    left = p;
                }
            }
        }

        return answer;
    }

    public static int dist(Point p, boolean hand) {
        if (hand) {
            return Math.abs(p.x - left.x) + Math.abs(p.y - left.y);
        } else {
            return Math.abs(p.x - right.x) + Math.abs(p.y - right.y);
        }
    }
}
