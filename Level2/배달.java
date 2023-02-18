import java.util.*;

class Town implements Comparable<Town>{
    private int number;
    private int cost;
    
    Town(int number, int cost) {
        this.number = number;
        this.cost = cost;
    }
    
    public int getCost() {
        return this.cost;
    }
    
    public int getNumber() {
        return this.number;
    }
    
    public int compareTo(Town t) {
        return this.cost <= t.cost ? -1 : 1;
    }
}

class Solution {
    
    public int solution(int N, int[][] road, int K) {
        int[] dist = new int[N+1];
        for (int i = 0; i <= N; i++)
            dist[i] = 999999;
        dist[1] = 0;
        
        PriorityQueue<Town> pq = new PriorityQueue();
        pq.add(new Town(1, 0));
        
        while (!pq.isEmpty()) {
            int cost = pq.peek().getCost();
            int num = pq.peek().getNumber();
            pq.poll();
            
            if (cost > dist[num]) continue;
            
            for (int i = 0; i < road.length; i++) {
                int cost2;
                int num2;
                if (road[i][0] == num) {
                    cost2 = road[i][2] + cost;
                    num2 = road[i][1];
                    
                    if (cost2 < dist[num2]) {
                        dist[num2] = cost2;
                        pq.add(new Town(num2, cost2));
                    }
                }
                else if (road[i][1] == num) {
                    cost2 = road[i][2] + cost;
                    num2 = road[i][0];
                    
                    if (cost2 < dist[num2]) {
                        dist[num2] = cost2;
                        pq.add(new Town(num2, cost2));
                    }
                }
            }
        }
        
        int answer = 0;
        for (int i : dist)
            if (i <= K) answer++;
        
        return answer;
    }
}
