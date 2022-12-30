import java.util.*;

class Solution {
    public List<Integer> solution(int[] numbers) {
        Set<Integer> answer = new HashSet();
        
        for (int i = 0; i < numbers.length; i++) 
            for (int j = i + 1; j < numbers.length; j++) {
                answer.add(numbers[i]+numbers[j]);
            }
        
        List<Integer> list = new ArrayList(answer);
        Collections.sort(list);
        
        return list;
    }
}
