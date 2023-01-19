class Solution {
    
    long dp[] = new long[1000001];
    
    void fibo(int n) {
        dp[0] = 0;
        dp[1] = 1;
        
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i-1] + dp[i-2]) % 1234567;
        }
    }
    
    public long solution(int n) {
        fibo(n);
        
        return dp[n];
    }
}
