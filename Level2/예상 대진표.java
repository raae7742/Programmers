class Solution
{
    private int goToNextRound(int n) {
        return (n % 2 == 0) ? n/2 : n/2 + 1;
    }
    
    public int solution(int n, int a, int b)
    {
        int answer = 0;
        
        while (a != b) {
            a = goToNextRound(a);
            b = goToNextRound(b);
            answer++;
        }

        return answer;
    }
}
