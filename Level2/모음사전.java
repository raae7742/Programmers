class Solution {
    String alphabet = "AEIOU";
    int[] cnt = {781, 156, 31, 6, 1};
    
    public int solution(String word) {
        int answer = word.length();
        
        for (int i = 0; i < word.length(); i++) {
            answer += (cnt[i] * alphabet.indexOf(word.charAt(i)));
        }
        
        return answer;
    }
}
