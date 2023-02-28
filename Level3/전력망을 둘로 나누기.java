import java.util.*;

class Solution {
    private int bfs(int start, int other, int[][] wires, int n) {
        int count = 1;
        
        Queue<Integer> q = new LinkedList();
        boolean visited[] = new boolean[n+1];
        
        q.add(start);
        visited[start] = true;
        
        while (!q.isEmpty()) {
            start = q.peek();
            q.remove();
            for (int i = 0; i < wires.length; i++) {
                if (wires[i][0] == start) {
                    int node = wires[i][1];
                    if (node == other) continue;
                    if (!visited[node]) {
                        visited[node] = true;
                        q.add(node);
                        count++;
                    }
                }
                else if (wires[i][1] == start) {
                    int node = wires[i][0];
                    if (node == other) continue;
                    if (!visited[node]) {
                        visited[node] = true;
                        q.add(node);
                        count++;
                    }
                }
            }
        }
        
        return count;
    }
    
    public int solution(int n, int[][] wires) {
        int answer = 101;
        
        for (int i = 0; i < wires.length; i++) {
            int a = wires[i][0];
            int b = wires[i][1];
            
            int result = Math.abs(bfs(a, b, wires, n) - bfs(b, a, wires, n));
            answer = (answer > result) ? result : answer;
        }
        
        return answer;
    }
}
