import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = { -1, -1 };
        Set<String> set = new HashSet();
        set.add(words[0]);
        String lastWord = words[0];
        
        int count = 1;
        boolean isSuccess = true;
        for (int i = 1; i < words.length; i++) {
            String word = words[i];
            count += 1;
            
            if (set.contains(word) || lastWord.charAt(lastWord.length() - 1) != word.charAt(0)) {
                isSuccess = false;
                break;                
            }
            
            set.add(word);
            lastWord = word;
        }
        
        if (isSuccess) {
            answer[0] = 0;
            answer[1] = 0;
        }
        else {
            answer[0] = ((count % n) == 0) ? n : count % n;
            answer[1] = ((count % n) == 0) ? count / n : count / n + 1;    
        }
        
        return answer;
    }
}
