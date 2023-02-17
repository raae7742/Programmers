class Solution {
    public String solution(int n) {
        String answer = "";
        int i = n;

        while(i > 0){
            if (i % 3 == 0){
                answer = "4" + answer;
                i--;
            } else {
                answer = Integer.toString(i % 3) + answer;
            }
            i /= 3;
        }
        
        return answer;
    }
}
