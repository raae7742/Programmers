class Solution {
    public int solution(int n) {
        int answer = 0;
        
        String ntos = Integer.toBinaryString(n);
        int count = 0;
        for (int i = 0; i < ntos.length(); i++)
            if (ntos.charAt(i) == '1') count++;
        
        for (int i = n + 1; i < 1000001; i++) {
            String itos = Integer.toBinaryString(i);
            int temp = 0;
            for (int j = 0; j < itos.length(); j++)
                if (itos.charAt(j) == '1') temp++;
            
            if (temp == count) {
                answer = i;
                break;
            }
        }
        
        return answer;
    }
}
