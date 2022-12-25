import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        int[] arr = new int[10001];
        
        Arrays.fill(arr, 0);
        
        Set<Integer> key2 = new HashSet();
        for (int i = 0; i < topping.length; i++) {
            arr[topping[i]]++;
            key2.add(topping[i]);
        }
        
        Set<Integer> key1 = new HashSet();
        for (int i = 0; i < topping.length; i++) {
            key1.add(topping[i]);
            if (--arr[topping[i]] <= 0) key2.remove(topping[i]);
            if (key2.size() == key1.size()) answer++;
        }
        
        return answer;
    }
}
