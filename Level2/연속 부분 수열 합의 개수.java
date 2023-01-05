import java.util.*;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> set = new HashSet();
        int len = elements.length;
        
        for (int i = 0; i < len; i++) {
            int sum = 0;
            
            for (int j = 0; j < len; j++) {
                int idx = (i + j) % len;
                sum += elements[idx];
                set.add(sum);
            }
        }
        
        return set.size();
    }
}
