class Solution {
    public String solution(String s) {
        String[] numbers = s.split(" ");
        
        int min = Integer.parseInt(numbers[0]);
        int max = Integer.parseInt(numbers[0]);
        for (String n : numbers) {
            int num = Integer.parseInt(n);
            min = (min > num) ? num : min;
            max = (max < num) ? num : max;
        }
        
        return Integer.toString(min) + " " + Integer.toString(max);
    }
}
