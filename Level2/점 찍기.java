class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        
        for (int x = 0; x <= d; x += k) {
            int yMax = getMaxDistance(x, d);
            answer += getCount(yMax, k);
        }
        
        return answer;
    }
    
    private static int getMaxDistance(int x, int d) {
        long xPow = (long) Math.pow(x, 2);
        long dPow = (long) Math.pow(d, 2);
        return (int)(Math.sqrt(dPow - xPow));
    }
    
    private static int getCount(int y, int k) {
        return y / k + 1;
    }
}
