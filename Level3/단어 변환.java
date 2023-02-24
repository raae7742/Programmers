class Solution {
    
    int answer = 0;
    boolean visited[] = new boolean[51];
    
    private void dfs(String current, String target, int count, String[] words) {
        if (current.compareTo(target) == 0) {
            if (answer == 0) answer = count;
            else answer = (answer > count) ? count : answer;
            
            return;
        }
        
        for (int i = 0; i < words.length; i++) {
            if (!visited[i]) {  
                int cnt = 0;
                for (int j = 0; j < words[i].length(); j++)
                    if (current.charAt(j) != words[i].charAt(j))
                        if (++cnt > 1) break;
                
                if (cnt == 1) {
                    visited[i] = true;
                    dfs(words[i], target, count+1, words);
                    visited[i] = false;
                }
            }
        }
    }
    
    public int solution(String begin, String target, String[] words) {
        dfs(begin, target, 0, words);
        
        return answer;
    }
}
