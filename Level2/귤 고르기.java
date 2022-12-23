import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap();
        
        for (int i : tangerine) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            }
            else {
                map.put(i, 1);
            }
        }
        
        List<Integer> list = new ArrayList(map.values());
        Collections.sort(list, Collections.reverseOrder());
        
        for (int i : list) {
            if (k <= 0) break;
            k -= i;
            answer++;
        }
        
        
        return answer;
    }
}
