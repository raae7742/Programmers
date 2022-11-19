import java.util.*;
import java.util.stream.Collectors;

class Solution {
    HashMap<String, Integer> map = new HashMap();
    
    public ArrayList<String> solution(String[] orders, int[] course) {
        ArrayList<String> answer = new ArrayList();
            
        for (int menuCount : course) {
            for (String order : orders) {
                char[] charSet = order.toCharArray();
                Arrays.sort(charSet);
                
                findMenuCombination(new String(charSet), "", menuCount);
            }   

            List<Map.Entry<String, Integer>> entries = map.entrySet().stream()
                    .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                    .collect(Collectors.toList());
            
            boolean isFirst = true;
            int max = 0;
            
            for (Map.Entry<String, Integer> entry : entries) {
                if (isFirst) {
                    max = entry.getValue();
                    isFirst = false;
                }
                if (entry.getValue() < max) break;
                if (entry.getValue() >= 2) answer.add(entry.getKey());
            }
            
            map = new HashMap();
            
        }
        
        Collections.sort(answer);
        return answer;
    }
    
    void findMenuCombination(String order, String combi, int count) {
        if (combi.length() >= count) {
            if (!map.containsKey(combi)) map.put(combi, 1);
            else map.put(combi, map.get(combi) + 1);
            
            return;
        }
        
        if (order.isBlank()) return;
        
        for (int i = 0; i < order.length(); i++) {
            String menu = order.substring(i, i+1);
            String newOrder = order.substring(i+1);                    
            findMenuCombination(newOrder, combi + menu, count);                              
        }
    }
}
