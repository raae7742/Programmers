class Solution {
    private int answer = 0;
    private boolean[] visited = new boolean[8];
    
    private void dfs(int level, int k, int[][] dungeons) {
        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && dungeons[i][0] <= k) {
                visited[i] = true;
                dfs(level+1, k-dungeons[i][1], dungeons);
                visited[i] = false;
            }
        }
        
        answer = (level > answer) ? level : answer;
    }
    
    public int solution(int k, int[][] dungeons) {
        dfs(0, k, dungeons);
        
        return answer;
    }
}
