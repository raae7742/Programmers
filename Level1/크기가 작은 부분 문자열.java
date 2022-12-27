class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        int len = p.length();
        
        for (int i = 0; i < t.length() - len + 1; i++) {
            String substr = t.substring(i, i + len);
            if (p.compareTo(substr) >= 0) answer++;
        }
        
        return answer;
    }
}
