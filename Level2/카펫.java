class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        for (int i = 1; i < 2000000; i++) {
            for (int j = 1; j <= i; j++) {
                if ((i * j == (brown + yellow)) && ((2 * (i+j) - 4) == brown)) {
                    answer[0] = i;
                    answer[1] = j;
                    return answer;
                }
            }
        }
        
        return answer;
    }
}
