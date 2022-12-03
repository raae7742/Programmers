import java.util.*;

class Solution {
    // rows: 2~100
    // columns: 2~100
    // queries: (x1, y1, x2, y2) 직사각형에서 테두리 숫자들을 한 칸씩 시계방향으로 회전
    // queries: 1~10000
    // answer: 위치가 바뀐 숫자들을 작은 숫자부터 배열에 담아 return
    public List<Integer> solution(int rows, int columns, int[][] queries) {
        List<Integer> answer = new ArrayList();
        
        int[][] matrix = new int[rows + 1][columns + 1];
        for (int i = 1; i < rows + 1; i++)
            for (int j = 1; j < columns + 1; j++)
                matrix[i][j] = (i-1) * columns + j;
        
        for (int[] query: queries) {
            int min = 999999;
            int x1 = query[0];
            int y1 = query[1];
            int x2 = query[2];
            int y2 = query[3];
            
            int temp = matrix[x1][y1];
            
            for (int x = x1; x < x2; x++) {
                if (matrix[x][y1] < min) min = matrix[x][y1];
                matrix[x][y1] = matrix[x+1][y1];
            }

            for (int y = y1; y < y2; y++) {
                if (matrix[x2][y] < min) min = matrix[x2][y];
                matrix[x2][y] = matrix[x2][y+1];            
            }
            
            for (int x = x2; x > x1; x--) {
                if (matrix[x][y2] < min) min = matrix[x][y2];
                matrix[x][y2] = matrix[x-1][y2];
            }

            for (int y = y2; y > y1; y--) {
                if (matrix[x1][y] < min) min = matrix[x1][y];
                matrix[x1][y] = matrix[x1][y-1];           
            }

            matrix[x1][y1+1] = temp;
            if (temp < min) min = temp;
            
            answer.add(min);
        }
                
        return answer;
    }
}
