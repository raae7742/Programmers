import java.util.*;
import java.util.stream.Collectors;

class Solution {
    // lottos: 구매한 로또 번호
    // win_nums: 1등 번호
    // result: [최고 순위, 최저 순위]
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = {0, 0};
        List<Integer> winNumList = Arrays.stream(win_nums).boxed().collect(Collectors.toList());
        int zeroCount = 0;
        int matchCount = 0;
        
        for (int num : lottos) {
            if (num == 0) {
                zeroCount++;
                continue;
            }

            if (winNumList.contains(num)) matchCount++;
        }
        
        answer[0] = 7 - matchCount - zeroCount;
        answer[1] = 7 - matchCount;
        
        if (answer[0] == 7) answer[0] = 6;
        if (answer[1] == 7) answer[1] = 6;
        
        return answer;
    }
}
