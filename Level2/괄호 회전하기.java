import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        Queue<Character> q = new LinkedList<Character>();
        
        for (int i = 0; i < s.length(); i++)
            q.add(s.charAt(i));
        
        for (int i = 0; i < s.length(); i++) {
            Stack<Character> st = new Stack();
            boolean flag = true;
            for (int j = 0; j < q.size(); j++) {
                char ch = q.peek();
                if (ch == '[' || ch == '(' || ch == '{') {
                    st.push(ch);
                }
                else {
                    if (ch == ']') {
                        if (!st.isEmpty() && st.peek() == '[') st.pop();
                        else flag = false;
                    }
                    if (ch == ')') {
                        if (!st.isEmpty() && st.peek() == '(') st.pop();
                        else flag = false;
                    }
                    if (ch == '}') {
                        if (!st.isEmpty() && st.peek() == '{') st.pop();
                        else flag = false;
                    }  
                }
                
                q.remove();
                q.add(ch);

            }
            
            if (st.isEmpty() && flag) answer++;
            
            char c = q.peek();
            q.remove();
            q.add(c);
        }
        
        
        return answer;
    }
}
