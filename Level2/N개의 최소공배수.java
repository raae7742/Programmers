class Solution {
    public int solution(int[] arr) {
        long max = 1;
        for (int i = 0; i < arr.length; i++)
            max *= arr[i];
        
        
        for (int i = 1; i <= max; i++) {
            boolean isLCM = true;
            for (int j = 0; j < arr.length; j++) {
                if (i % arr[j] != 0) {
                    isLCM = false;
                    break;
                }
            }
            
            if (isLCM) return i;
        }
        
        return -1;
    }
}
