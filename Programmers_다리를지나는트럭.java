class Solution {
    
    static class Node {
        public int weight;
        public int time;

        public Node(int weight) {
            this.weight = weight;
            this.time = 0;
        }

        public void turn() {
            this.time++;
        }
    }

    static class Queue {
        private Node[] arr;
        private int front = 0;
        private int end = 0;
        private int time;

        public Queue(int time) {
            this.arr = new Node[10000];
            this.time = time;
        }

        public boolean isEmpty() {
            return front - end == 0;
        }

        public void push(Node x) {
            arr[end++] = x;
        }

        public int pop() {
            return arr[front++].weight;
        }

        public boolean isArrived() {
            if(isEmpty()) return false;
            return arr[front].time >= time;
        }

        public void turn() {
            for(int i=front; i<end; i++) {
                arr[i].turn();
            }
        }
    }
    
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int onBridge = 0;
        int idx = 0;

        Queue q = new Queue(bridge_length);

        while (idx<truck_weights.length) {
            answer++;
            if(q.isArrived()) {
                onBridge -= q.pop();
            }
            if (weight >= onBridge + truck_weights[idx]) {
                onBridge += truck_weights[idx];
                q.push(new Node(truck_weights[idx++]));
            }
            q.turn();
        }
        
        while(!q.isEmpty()) {
            answer++;
            if(q.isArrived()) {
                onBridge -= q.pop();
            }
            q.turn();
        }

        return answer;
    }
}
