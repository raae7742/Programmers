class Solution {
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        
        char[][] arr = new char[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                arr[i][j] = board[i].charAt(j);
        
        while (true) {
            boolean inProgress = false;
            boolean pang[][] = new boolean[m][n];
            
            for (int i = 0; i < m; i++)
                for (int j = 0; j < n; j++)
                    pang[i][j] = false;
            
            for (int i = 0; i < m-1; i++) {
                for (int j = 0; j < n-1; j++) {
                    if (arr[i][j] == '-') continue;
                    
                    if (arr[i][j] == arr[i+1][j]
                       && arr[i+1][j] == arr[i][j+1]
                       && arr[i][j+1] == arr[i+1][j+1]) {
                        pang[i][j] = true;
                        pang[i][j+1] = true;
                        pang[i+1][j] = true;
                        pang[i+1][j+1] = true;
                        inProgress = true;
                    }
                }
            }
            
            if (!inProgress) break;
            
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (pang[i][j]) {
                        arr[i][j] = '-';
                        answer++;
                        
                        int idx = i;
                        while (idx > 0) {
                            char temp = arr[idx][j];
                            arr[idx][j] = arr[idx-1][j];
                            arr[idx-1][j] = temp;
                            idx--;
                        }
                    }
                }
            }
        }
        
        return answer;
    }
}
