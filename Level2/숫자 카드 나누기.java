import java.util.*;

class Solution {
    
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        
        int minA = Arrays.stream(arrayA).min().getAsInt();
        int minB = Arrays.stream(arrayB).min().getAsInt();
        
        Set<Integer> set = new HashSet();
        for (int i = 2; i <= minA; i++)
            if (minA % i == 0) set.add(i);

        for (int i = 2; i <= minB; i++)
            if (minB % i == 0) set.add(i);

        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list, Collections.reverseOrder());
        
        for (int num : list) {
            boolean flag = true;
            
            for (int i = 0; i < arrayA.length; i++) {
                if (arrayA[i] % num != 0 || arrayB[i] % num == 0) {
                    flag = false;
                    break;
                }
            }
            
            if (flag) {
                answer = Math.max(answer, num);
                continue;
            }
            flag = true;
            
            for (int i = 0; i < arrayA.length; i++) {
                if (arrayB[i] % num != 0 || arrayA[i] % num == 0) {
                    flag = false;
                    break;
                }
            }
            
            if (flag) answer = Math.max(answer, num);
            
        }
        
        return answer;
    }
}
