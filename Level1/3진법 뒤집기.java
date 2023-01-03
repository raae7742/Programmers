class Solution {
    public int solution(int n) {
        String reverseNum = new StringBuffer(Integer.toString(n, 3))
            .reverse().toString();
        
        return Integer.parseInt(reverseNum, 3);
        
    }
}
