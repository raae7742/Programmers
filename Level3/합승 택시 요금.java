import java.util.Arrays;

class Solution {
    // n: 지점 개수 (3 ~ 200)
    // s: 출발 지점
    // a: A의 도착 지점
    // b: B의 도착 지점
    // fares: 지점 사이의 예상 택시 요금([지점 c, 지점 d, c-d 사이 요금])
    public int solution(int n, int s, int a, int b, int[][] fares) {
        final int MAX = 9999999;
        int answer = MAX;
        
        int[][] distance = new int[n+1][n+1];
        for (int i = 1; i < n+1; i++)
            Arrays.fill(distance[i], MAX);
        
        // 요금 값 저장
        for (int i = 0; i < fares.length; i++) {
            int start = fares[i][0];
            int end = fares[i][1];
            int cost = fares[i][2];
        
            distance[start][end] = cost;
            distance[end][start] = cost;
        }
        
        // 최단경로 배열 만들기
        for (int i = 1; i < n+1; i++)
            for (int j = 1; j < n+1; j++)
                for (int k = 1; k < n+1; k++) {
                    if (j == k) distance[j][k] = 0;
                    distance[j][k] = Math.min(distance[j][k], distance[j][i] + distance[i][k]);
                }
        
        for (int i = 1; i < n+1; i++)
            if (distance[s][i] != MAX) {
                answer = Math.min(answer, distance[s][i] + distance[i][a] + distance[i][b]);
                System.out.println(i + ": " + answer);
            }
        
        return answer;
    }
}
