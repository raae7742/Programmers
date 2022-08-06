#include <vector>
using namespace std;

int solution(vector<int> nums)
{
    int answer = 0;
    int ponketmon[200000] = { 0 };
    
    for (int i = 0; i < nums.size(); i++) {
        if (ponketmon[nums[i]] == 0) {
            ponketmon[nums[i]] = 1;
            
            if (++answer >= nums.size() / 2) 
                break;
        }
    }
    
    return answer;
}
