import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        
        Stack<Integer> container = new Stack();
        int index = 0;
        
        for (int i = 1; i <= order.length; i++) {
            if (i != order[index]) {
                container.push(i);
                continue;
            }
            
            answer++;
            index++;

            while (!container.isEmpty() && container.peek() == order[index]) {
                answer++;
                index++;
                container.pop();
            }

        }
        
        return answer;
    }
}
