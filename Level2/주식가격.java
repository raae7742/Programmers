import java.util.*;

class Solution {
    
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        Stack<Integer> stack = new Stack();
        stack.push(0);
        
        for (int i = 1; i < prices.length; i++) {
            
            int lastIndex = stack.peek();
            while (prices[lastIndex] > prices[i]) {
                stack.pop();
                answer[lastIndex] = i - lastIndex;
                
                if (stack.isEmpty()) break;
                lastIndex = stack.peek();
            }
            
            stack.push(i);
        }
        
        while (!stack.isEmpty()) {
            int index = stack.peek();
            stack.pop();
            answer[index] = prices.length - index - 1;
        }
        
        return answer;
    }
}
