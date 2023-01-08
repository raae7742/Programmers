import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> map = new HashMap();
        
        for (String[] lst : clothes) {
            if (map.containsKey(lst[1])) {
                map.put(lst[1], map.get(lst[1]) + 1);
            }
            else {
                map.put(lst[1], 1);
            }
        }
        
        for (String key : map.keySet()) {
            answer *= (map.get(key) + 1);
        }
        
        return answer - 1;
    }
}
