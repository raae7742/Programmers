class Solution {
    
    int[][] globalArr;
    int cnt0 = 0;
    int cnt1 = 0;
    
    int dfs(int start_x, int end_x, int start_y, int end_y) {
        if (end_x - start_x <= 1) return globalArr[start_x][start_y];
        
        int mid_x = (start_x + end_x) / 2;
        int mid_y = (start_y + end_y) / 2;
        
        int[] result = new int[4];
        result[0] = dfs(start_x, mid_x, start_y, mid_y);
        result[1] = dfs(mid_x, end_x, start_y, mid_y);
        result[2] = dfs(start_x, mid_x, mid_y, end_y);
        result[3] = dfs(mid_x, end_x, mid_y, end_y);
        
        if (result[0] == result[1] && 
            result[1] == result[2] && 
            result[2] == result[3]) {
            return result[0];
        }
        else {
            for (int i = 0; i < 4; i++) {
                if (result[i] == 0) cnt0++;
                else if (result[i] == 1) cnt1++;
            }
            return -1;
        } 
    }
    
    public int[] solution(int[][] arr) {
        int[] answer = { 0, 0 };
        globalArr = arr;
        
        int num = dfs(0, arr.length, 0, arr.length);
        if (num == 0) cnt0++;
        else if (num == 1) cnt1++;
        
        answer[0] = cnt0;
        answer[1] = cnt1;
        
        return answer;
    }
}
