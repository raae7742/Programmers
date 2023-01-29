import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;

        for (int i = 0; i < citations[citations.length-1]; i++) {
            int cnt = 0;
            for (int j : citations)
                if (j >= i) cnt++;
            
            if (i <= cnt) answer = i;
        }
        
        return answer;
    }
}
