#include <string>
#include <vector>
#include <iostream>
#include <algorithm>

using namespace std;

// lottos: 민우가 구매한 로또 번호
// win_nums: 당첨 번호
vector<int> solution(vector<int> lottos, vector<int> win_nums) {
    vector<int> answer;
    int zero_count = 0;
    int lotto_count = 0;
    
    for (int i = 0; i < lottos.size(); i++) {
        if (lottos[i] == 0) {
            zero_count++;
            continue;
        }
        
        for (int j = 0; j < win_nums.size(); j++) {
            if (win_nums[j] == lottos[i]) {
                lotto_count++;
                win_nums.erase(win_nums.begin() + j);
            }
        }
    }

    int max = lotto_count + zero_count;
    if (max > 6) max = 6;

    if (max >= 2) answer.push_back(7 - max);
    else answer.push_back(6);

    if (lotto_count >= 2) answer.push_back(7 - lotto_count);
    else answer.push_back(6);

    return answer;
}
