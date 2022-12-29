import java.util.*;

class Solution {
    Map<String, List<Integer>> map = new HashMap();
    
    public List<Integer> solution(String[] info, String[] query) {
        List<Integer> answer = new ArrayList();
        
        for (String applicant : info) {
            String[] app_info = applicant.split(" ");
            dfs(app_info, "", 0);
        }
        
        for (String key : map.keySet()) {
            Collections.sort(map.get(key));
        }
        
        for (String q : query) {
            String[] condition = q.split(" ");
            String key = condition[0] + condition[2] + condition[4] + condition [6];
            int score = Integer.parseInt(condition[7]);
            
            if (map.containsKey(key)) answer.add(binarySearch(key, score));
            else answer.add(0);
        }
        
        return answer;
    }
    
    private void dfs(String[] info, String str, int count) {
        if (count == 4) {
            if (!map.containsKey(str)) {
                List<Integer> list = new ArrayList<Integer>();
                map.put(str, list);
            }
            
            map.get(str).add(Integer.parseInt(info[4]));
            return;
        }
        
        dfs(info, str + "-", count+1);
        dfs(info, str + info[count], count+1);
    }
    
    private int binarySearch(String key, int score) {
        List<Integer> list = map.get(key);
        int start = 0, end = list.size() - 1;
        
        while (start <= end) {
            int mid = (start + end) / 2;
            if (score > list.get(mid)) start = mid + 1;
            else end = mid - 1;
        }
        
        return list.size() - start;
    }
}
