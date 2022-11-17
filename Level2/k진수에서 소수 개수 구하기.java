import java.util.*;

class Solution {
    public long solution(int n, int k) {
        int answer = 0;

        ArrayList<Integer> xk = convert(n, k);
        
        long x10 = 0;
        for (int num : xk) {
            if (num == 0) {
                if (isPrime(x10)) answer++;
                x10 = 0;
            }
            else {
                x10 = x10 * 10 + num;
            }
        }
        if (isPrime(x10)) answer++;
        
        return answer;
    }
    
    ArrayList<Integer> convert(int n, int k) {
        ArrayList<Integer> list = new ArrayList();
        while (n > 0) {
            list.add(n % k);
            n /= k;
        }
        Collections.reverse(list);
        return list;
    }
    
    boolean isPrime(long n) {
        if (n <= 1) return false;
        for (long i = 2; i*i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
