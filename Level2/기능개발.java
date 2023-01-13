import java.util.*;

class Solution {
    class Func {
        int progress;
        int speed;
        
        public Func(int progress, int speed) {
            this.progress = progress;
            this.speed = speed;
        }
    }
    
    public List<Integer> solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList();
        Queue<Func> q = new LinkedList();
        
        for (int i = 0; i < progresses.length; i++) {
            q.add(new Func(progresses[i], speeds[i]));
        }
        
        while (!q.isEmpty()) {
            for (int i = 0; i < q.size(); i++) {
                Func f = q.poll();
                if (f.progress < 100) f.progress += f.speed;
                q.add(f);
            }
            
            int cnt = 0;
            while(!q.isEmpty() && q.peek().progress >= 100) {
                q.remove();
                cnt++;
            }
            
            if (cnt > 0) answer.add(cnt);
        }
        
        return answer;
    }
}
