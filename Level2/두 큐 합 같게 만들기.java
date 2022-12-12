import java.util.*;

class Solution {
    
    final int MAX = 600000;
    
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        
        Queue<Integer> q1 = new LinkedList();
        Queue<Integer> q2 = new LinkedList();
        
        long sum1 = 0;
        long sum2 = 0;
        
        for (int q : queue1) {
            sum1 += q;
            q1.add(q);
        }
        
        for (int q : queue2) {
            sum2 += q;
            q2.add(q);
        }
        
        long threshold = (sum1 + sum2) / 2;
        while (sum1 != sum2) {
            if (sum1 > sum2) {
                int num = q1.poll();
                sum1 -= num;
                
                q2.add(num);
                sum2 += num;
            }
            else {
                int num = q2.poll();
                sum2 -= num;
                
                q1.add(num);
                sum1 += num;
            }
            answer++;
            
            if (answer > MAX) {
                answer = -1;
                break;                
            }
        }
        
        return answer;
    }
}
