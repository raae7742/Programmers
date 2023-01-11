import java.util.*;

class Solution {
    
    class Pair {
        int index;
        int priority;
        
        Pair(int index, int priority) {
            this.index = index;
            this.priority = priority;
        }
    }
    
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Pair> q = new LinkedList();
                
        for (int i = 0; i < priorities.length; i++) {
            Pair p = new Pair(i, priorities[i]);
            q.add(p);
        }
        
        int currentIdx = 0;
        Integer[] tmp = Arrays.stream(priorities).boxed().toArray(Integer[]::new);
        Arrays.sort(tmp, Comparator.reverseOrder());
 
        while (!q.isEmpty()) {
            Pair top = q.poll();
            
            if (top.priority == tmp[currentIdx]) {
                answer++;
                currentIdx++;
                if (location == top.index) break;
            }
            else {
                q.add(top);
            }
        }
        
        return answer;
    }
}
