import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
                
        for (String st : skill_trees) {
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < st.length(); i++) {
                if (skill.contains(String.valueOf(st.charAt(i))))
                    sb.append(st.charAt(i));
            }
            
            int index = 0;
            boolean isPossible = true;
            for (int i = 0; i < sb.length(); i++) {
                String sk = sb.substring(i, i+1);
                if (skill.contains(sk)) {
                    if (!String.valueOf(skill.charAt(index)).equals(sk)) {
                        isPossible = false;
                        break;
                    }
                    
                    index++;
                }
            }
            
            if (isPossible) answer++;
        }
        
        return answer;
    }
}
