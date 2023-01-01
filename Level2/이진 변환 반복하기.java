class Solution {
    public int[] solution(String s) {
        int[] answer = { 0, 0 };
        
        int cnt = 0;
        int zero = 0;
        
        while (s.length() > 1) {
            int one = 0;
            for (int i = 0; i < s.length(); i++)
                if (s.charAt(i) == '1') one++;
            
            zero += s.length() - one;
            s = Integer.toBinaryString(one);
            cnt++;
        }
        
        answer[0] = cnt;
        answer[1] = zero;
        
        return answer;
    }
}
