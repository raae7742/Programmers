import java.util.*;

class Solution {
    
    public List<Long> solution(long[] numbers) {
        List<Long> answer = new ArrayList();
        
        for (Long num : numbers) {
            if (num % 2 == 0) {
                answer.add(num + 1);
            }
            else {
                String sb = Long.toBinaryString(num);
                int idx = sb.lastIndexOf('0');
                int p;
                
                if (idx != -1) p = sb.length() - 1 - idx;
                else p = sb.length();
                
                answer.add(num - Double.valueOf(Math.pow(2, p-1) - Math.pow(2, p)).longValue());                    
            }
        }
        
        
        return answer;
    }
}
